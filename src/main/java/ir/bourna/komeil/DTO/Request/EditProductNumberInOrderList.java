package ir.bourna.komeil.DTO.Request;

public class EditProductNumberInOrderList {
    Long productItemId;
    Long orderListId;
    int number;

    public EditProductNumberInOrderList(Long productItemId, Long orderListId, int number) {
        this.productItemId = productItemId;
        this.orderListId = orderListId;
        this.number = number;
    }

    public Long getProductItemId() {
        return productItemId;
    }

    public void setProductItemId(Long productItemId) {
        this.productItemId = productItemId;
    }

    public Long getOrderListId() {
        return orderListId;
    }

    public void setOrderListId(Long orderListId) {
        this.orderListId = orderListId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
