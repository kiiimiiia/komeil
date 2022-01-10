package ir.bourna.komeil.models.Enums;

public enum DiscountType {
    PERCENT("درصد"),
    CASH("نقد");

    public final String label;
    DiscountType(String label){
        this.label = label;
    }
}
