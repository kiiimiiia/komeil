package ir.bourna.komeil.controllers.web.requests;

public class CompeletOrderRequest {
    Long orderListId;
    Long addressId;
    Long transporstId;

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
}
