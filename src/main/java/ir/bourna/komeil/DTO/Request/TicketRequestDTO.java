package ir.bourna.komeil.DTO.Request;


import ir.bourna.komeil.models.Enums.TicketStatus;

public class TicketRequestDTO {

    private String mobile;
    private String content;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
