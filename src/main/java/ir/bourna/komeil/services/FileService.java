package ir.bourna.komeil.services;

import ir.bourna.komeil.DTO.Response.UploadImageResponseDTO;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


public interface FileService {
    UploadImageResponseDTO saveImage(final MultipartFile file);

    Resource loadFileAsResource(String fileName);
}
