package ir.bourna.komeil.models.Enums;

public enum OrderStatus {
    FAIL("ناموفق"),
    PAID("پرداخت شده"),
    NOT_PAID("پرداخت نشده"),
    SENT("فرستاده شده"),
    RECEIVED("دریافت شده"),
    ALL("همه");

    public final String label;

    OrderStatus(String label){
        this.label = label;
    }
}
