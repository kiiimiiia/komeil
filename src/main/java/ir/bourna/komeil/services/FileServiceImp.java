package ir.bourna.komeil.services;


import ir.bourna.komeil.DTO.Response.FileStoragePropertiesResponseDTO;
import ir.bourna.komeil.DTO.Response.UploadImageResponseDTO;
import ir.bourna.komeil.config.FileStorageException;
import ir.bourna.komeil.config.MyFileNotFoundException;
import ir.bourna.komeil.models.FileEntity;
import ir.bourna.komeil.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
public class FileServiceImp implements FileService {
    private final Path fileStorageLocation;
    private final FileRepository fileRepository;

    @Autowired
    public FileServiceImp( FileStoragePropertiesResponseDTO fileStoragePropertiesResponseDTO, final FileRepository fileRepository) {
        this.fileStorageLocation = Paths.get(fileStoragePropertiesResponseDTO.getUploadDir()).toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (IOException ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
        this.fileRepository = fileRepository;
    }

    @Override
    public UploadImageResponseDTO saveImage(MultipartFile file) {
        if (file != null) {
            String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
            final long time = System.currentTimeMillis();
            fileName = this.generateUniqueFileName(fileName, time);
            try {
                if (fileName.contains("..")) {
                    throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
                }
                final Path targetLocation = this.fileStorageLocation.resolve(fileName);
                Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
                final String fileDownloadUri = this.getFileDownloadUrl(fileName);
                final FileEntity fileEntity = new FileEntity();
                fileEntity.setPath(fileDownloadUri);
                final FileEntity savedProfile = fileRepository.save(fileEntity);
                return new UploadImageResponseDTO(savedProfile.getId(), savedProfile.getPath());
            } catch (IOException ex) {
                throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
            }
        }
        throw new FileStorageException("Sorry! Filename nor exist");
    }

    @Override
    public Resource loadFileAsResource(String fileName) {
        try {
            final Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            final Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            }
            throw new MyFileNotFoundException("File not found " + fileName);
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        }
    }
    private String generateUniqueFileName(final String fileName, final long timeStamp) {
        final StringBuilder stringBuilder = new StringBuilder(fileName);
        return stringBuilder.insert(fileName.lastIndexOf(46), timeStamp).toString();
    }

    private String getFileDownloadUrl(final String fileName) {
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/utility/downloadFile/").path(fileName).toUriString();
    }
}
