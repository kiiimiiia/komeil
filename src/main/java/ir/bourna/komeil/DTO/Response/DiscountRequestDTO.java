package ir.bourna.komeil.DTO.Response;

import ir.bourna.komeil.models.Enums.DiscountType;

public class DiscountRequestDTO {
    DiscountType discountType;
    int value;
    String hashcode;

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getHashcode() {
        return hashcode;
    }

    public void setHashcode(String hashcode) {
        this.hashcode = hashcode;
    }
}
