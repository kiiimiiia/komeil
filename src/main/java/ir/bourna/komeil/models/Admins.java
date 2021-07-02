package ir.bourna.komeil.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "admins")
@Entity
public class Admins extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "enable")
    private Boolean enable = true;
    @Column(name = "static_role")
    private Boolean static_role;
    @Column(name = "admin_role")
    private Boolean admin_role;
    @Column(name = "product_role")
    private Boolean product_role;
    @Column(name = "news_role")
    private Boolean news_role;
    @Column(name = "category_role")
    private Boolean category_role;
    @Column(name = "filter_role")
    private Boolean filter_role;
    @Column(name = "transport_role")
    private Boolean transport_role;
    @Column(name = "brand_role")
    private Boolean brand_role;
    @Column(name = "color_role")
    private Boolean color_role;
    @Column(name = "banner_role")
    private Boolean banner_role;
    @Column(name = "ticket_role")
    private Boolean ticket_role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Boolean getStatic_role() {
        return static_role;
    }

    public void setStatic_role(Boolean static_role) {
        this.static_role = static_role;
    }

    public Boolean getAdmin_role() {
        return admin_role;
    }

    public void setAdmin_role(Boolean admin_role) {
        this.admin_role = admin_role;
    }

    public Boolean getProduct_role() {
        return product_role;
    }

    public void setProduct_role(Boolean product_role) {
        this.product_role = product_role;
    }

    public Boolean getNews_role() {
        return news_role;
    }

    public void setNews_role(Boolean news_role) {
        this.news_role = news_role;
    }

    public Boolean getCategory_role() {
        return category_role;
    }

    public void setCategory_role(Boolean category_role) {
        this.category_role = category_role;
    }

    public Boolean getFilter_role() {
        return filter_role;
    }

    public void setFilter_role(Boolean filter_role) {
        this.filter_role = filter_role;
    }

    public Boolean getTransport_role() {
        return transport_role;
    }

    public void setTransport_role(Boolean transport_role) {
        this.transport_role = transport_role;
    }

    public Boolean getBrand_role() {
        return brand_role;
    }

    public void setBrand_role(Boolean brand_role) {
        this.brand_role = brand_role;
    }

    public Boolean getColor_role() {
        return color_role;
    }

    public void setColor_role(Boolean color_role) {
        this.color_role = color_role;
    }

    public Boolean getBanner_role() {
        return banner_role;
    }

    public void setBanner_role(Boolean banner_role) {
        this.banner_role = banner_role;
    }

    public Boolean getTicket_role() {
        return ticket_role;
    }

    public void setTicket_role(Boolean ticket_role) {
        this.ticket_role = ticket_role;
    }
}
