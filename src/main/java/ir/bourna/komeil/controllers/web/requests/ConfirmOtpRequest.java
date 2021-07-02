package ir.bourna.komeil.controllers.web.requests;

public class ConfirmOtpRequest{
    private String mobile;
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
