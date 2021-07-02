package ir.bourna.komeil.DTO.Response;

public class UploadImageResponseDTO {

    public String path;
    public int id;

    public UploadImageResponseDTO(int id, String path) {
        this.id=id;
        this.path=path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
