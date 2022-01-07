package ir.bourna.komeil.DTO.Request;

public class PaymentVerifyResquest {
    private Long orderListId;
    private String respmsg;
    private int respcode;
    private int amount;
    private String invoiceid;
    private String payload;
    private Long terminalid;
    private Long tracenumber;
    private Long rrn;
    private String  datePaid;
    private String  digitalreceipt;
    private String  issuerbank;
    private String  cardnumber;

    public Long getOrderListId() {
        return orderListId;
    }

    public void setOrderListId(Long orderListId) {
        this.orderListId = orderListId;
    }

    public String getRespmsg() {
        return respmsg;
    }

    public void setRespmsg(String respmsg) {
        this.respmsg = respmsg;
    }

    public int getRespcode() {
        return respcode;
    }

    public void setRespcode(int respcode) {
        this.respcode = respcode;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(String invoiceid) {
        this.invoiceid = invoiceid;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public Long getTerminalid() {
        return terminalid;
    }

    public void setTerminalid(Long terminalid) {
        this.terminalid = terminalid;
    }

    public Long getTracenumber() {
        return tracenumber;
    }

    public void setTracenumber(Long tracenumber) {
        this.tracenumber = tracenumber;
    }

    public Long getRrn() {
        return rrn;
    }

    public void setRrn(Long rrn) {
        this.rrn = rrn;
    }

    public String getDatePaid() {
        return datePaid;
    }

    public void setDatePaid(String datePaid) {
        this.datePaid = datePaid;
    }

    public String getDigitalreceipt() {
        return digitalreceipt;
    }

    public void setDigitalreceipt(String digitalreceipt) {
        this.digitalreceipt = digitalreceipt;
    }

    public String getIssuerbank() {
        return issuerbank;
    }

    public void setIssuerbank(String issuerbank) {
        this.issuerbank = issuerbank;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }
}
