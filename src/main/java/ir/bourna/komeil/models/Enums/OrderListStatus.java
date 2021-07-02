package ir.bourna.komeil.models.Enums;

public enum OrderListStatus {
    FAIL("ناموفق"),
    PAID("پرداخت شده"),
    NOT_PAID("پرداخت نشده"),
    SENT("فرستاده شده"),
    RECEIVED("دریافت شده");

    public final String label;

    OrderListStatus(String label){
        this.label = label;
    }
}
