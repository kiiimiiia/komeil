package ir.bourna.komeil.DTO.Response;

public class GetAccessTokenResponse {
    private int Status;
    private String Accesstoken;

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getAccesstoken() {
        return Accesstoken;
    }

    public void setAccesstoken(String accesstoken) {
        Accesstoken = accesstoken;
    }
}
