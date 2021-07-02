package ir.bourna.komeil.controllers;

import io.swagger.annotations.ApiOperation;
import ir.bourna.komeil.DTO.Response.UploadImageResponseDTO;
import ir.bourna.komeil.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1/utility")
public class UtilityController {
    @Autowired
    FileService fileService;

    @PostMapping("/image")
    @ApiOperation("Api for posting image ")
    public UploadImageResponseDTO uploadProfile(@RequestParam(value = "file", required = true) final MultipartFile file) throws Exception {
        return fileService.saveImage(file);
  }

    @GetMapping({ "/downloadFile/{fileName:.+}" })
    public ResponseEntity<Resource> downloadFile(@PathVariable final String fileName, final HttpServletRequest request) {
        final Resource resource = this.fileService.loadFileAsResource(fileName);
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        }
        catch (IOException ex) {
            System.out.println("Could not determine file type.");
        }
        if (contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType)).header("Content-Disposition",
                "attachment; filename=\"" + resource.getFilename() + "\"").body(resource);
    }


}
