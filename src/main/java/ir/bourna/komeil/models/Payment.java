package ir.bourna.komeil.models;

import ir.bourna.komeil.models.Enums.OrderStatus;

import javax.persistence.*;

@Entity
@Table(name = "payment")
public class Payment extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "order_list_id")
    private Long orderListId;

    @Column(name = "respmsg")
    private String respmsg;

    @Column(name = "respcode")
    private int respcode;

    @Column(name = "amount")
    private int amount;

    @Column(name = "invoiceid")
    private String invoiceid;

    @Column(name = "payload")
    private String payload;

    @Column(name = "terminalid")
    private Long terminalid;

    @Column(name = "tracenumber")
    private Long tracenumber;

    @Column(name = "rrn")
    private Long rrn;

    @Column(name = "datePaid")
    private String  datePaid;

    @Column(name = "digitalreceipt")
    private String  digitalreceipt;

    @Column(name = "issuerbank")
    private String  issuerbank;

    @Column(name = "cardnumber")
    private String  cardnumber;

    @Column(name = "AccessToken")
    private String  AccessToken;

    @Column(name = "UserCode")
    private String  UserCode;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getAccessToken() {
        return AccessToken;
    }

    public void setAccessToken(String accessToken) {
        AccessToken = accessToken;
    }

    public String getUserCode() {
        return UserCode;
    }

    public void setUserCode(String userCode) {
        UserCode = userCode;
    }
}
