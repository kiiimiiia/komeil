package ir.bourna.komeil.DTO.Request;

public class ProductitemColorRequestDTO {
    private Long Productid;
    private Long id;
    private Integer num;

    public Long getProductid() {
        return Productid;
    }

    public void setProductid(Long productid) {
        Productid = productid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
