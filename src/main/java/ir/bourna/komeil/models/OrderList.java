package ir.bourna.komeil.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ir.bourna.komeil.models.Enums.OrderStatus;
import ir.bourna.komeil.models.intermediate.OrderListProductItemNumber;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "order_list")
public class OrderList extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id",  nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    @JsonIgnore
    @OneToMany(mappedBy = "orderList")
    private Set<OrderListProductItemNumber> orderListProductItemNumberSet = new HashSet<>();
    @Column(name = "transport_id")
    private Long transportId;
    @Column(name = "address_id")
    private Long addressId;
    @Column(name = "discountid")
    private Long disCountId;


    public OrderList() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public Set<OrderListProductItemNumber> getOrderListProductItemNumberSet() {
        return orderListProductItemNumberSet;
    }

    public void setOrderListProductItemNumberSet(Set<OrderListProductItemNumber> orderListProductItemNumberSet) {
        this.orderListProductItemNumberSet = orderListProductItemNumberSet;
    }

    public Long getTransportId() {
        return transportId;
    }

    public void setTransportId(Long transportId) {
        this.transportId = transportId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getDisCountId() {
        return disCountId;
    }

    public void setDisCountId(Long disCountId) {
        this.disCountId = disCountId;
    }
}