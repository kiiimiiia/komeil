package ir.bourna.komeil.controllers.web.requests;

public class CompeletOrderRequest {
    Long orderListId;
    Long addressId;
    Long transporstId;
    String  totalprice;
    String description;
    Long discountId;
    public Long getOrderListId() {
        return orderListId;
    }

    public void setOrderListId(Long orderListId) {
        this.orderListId = orderListId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Long getTransporstId() {
        return transporstId;
    }

    public void setTransporstId(Long transporstId) {
        this.transporstId = transporstId;
    }

    public String getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Long discountId) {
        this.discountId = discountId;
    }
}
