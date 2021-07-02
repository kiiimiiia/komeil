package ir.bourna.komeil.models;

import ir.bourna.komeil.models.Enums.OtpStatus;

import javax.persistence.*;

@Entity
@Table(name = "verification_code")
public class Otp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "mobile")
    private String mobile;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OtpStatus status;

    @Column(name = "code")
    private String code;

    public Otp() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public OtpStatus getStatus() {
        return status;
    }

    public void setStatus(OtpStatus status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
