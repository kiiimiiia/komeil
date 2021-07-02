package ir.bourna.komeil.DTO.Response;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file")
public class FileStoragePropertiesResponseDTO
{
    private String uploadDir;
    
    public String getUploadDir() {
        return this.uploadDir;
    }
    
    public void setUploadDir(final String uploadDir) {
        this.uploadDir = uploadDir;
    }
}
