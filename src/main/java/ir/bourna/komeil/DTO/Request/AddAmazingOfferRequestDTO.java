package ir.bourna.komeil.DTO.Request;

public class AddAmazingOfferRequestDTO {
    private Long startDate;
    private Long endDate;
    private Long productItem;

    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public Long getEndDate() {
        return endDate;
    }

    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }

    public Long getProductItem() {
        return productItem;
    }

    public void setProductItem(Long productItem) {
        this.productItem = productItem;
    }
}
