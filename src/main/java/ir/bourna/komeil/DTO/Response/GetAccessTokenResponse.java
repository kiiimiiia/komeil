package ir.bourna.komeil.DTO.Response;

public class GetAccessTokenResponse {
    private int Status;
    private String AccessToken;

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getAccessToken() {
        return AccessToken;
    }

    public void setAccessToken(String accessToken) {
        AccessToken = accessToken;
    }
}
