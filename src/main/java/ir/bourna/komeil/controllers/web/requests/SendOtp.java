package ir.bourna.komeil.controllers.web.requests;

public class SendOtp {
    String mobile;
    Integer templateId;
    ParametrSendOtp[] parameters;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public ParametrSendOtp[] getParameters() {
        return parameters;
    }

    public void setParameters(ParametrSendOtp[] parameters) {
        this.parameters = parameters;
    }
}
