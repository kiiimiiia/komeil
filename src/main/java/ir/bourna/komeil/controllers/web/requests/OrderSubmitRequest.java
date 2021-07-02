package ir.bourna.komeil.controllers.web.requests;
public class OrderSubmitRequest {
    Long pid ;
    Integer number ;
    Long colorId;

    public OrderSubmitRequest(Long pid, Integer number, Long colorId) {
        this.pid = pid;
        this.number = number;
        this.colorId = colorId;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Long getColorId() {
        return colorId;
    }

    public void setColorId(Long colorId) {
        this.colorId = colorId;
    }
}
