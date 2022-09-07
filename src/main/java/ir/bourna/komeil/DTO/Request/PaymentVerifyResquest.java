package ir.bourna.komeil.DTO.Request;

public class PaymentVerifyResquest {
    private Long orderListId;
    private String respmsg;
    private int respcode;
    private String  amount;
    private String invoiceid;
    private Long terminalid;
    private Long tracenumber;
    private Long rrn;
    private String  datepaid;
    private String  digitalreceipt;
    private String  issuerbank;
    private String  cardnumber;
    private String  payload;
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(String invoiceid) {
        this.invoiceid = invoiceid;
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

    public String getDatepaid() {
        return datepaid;
    }

    public void setDatepaid(String datepaid) {
        this.datepaid = datepaid;
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

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}
