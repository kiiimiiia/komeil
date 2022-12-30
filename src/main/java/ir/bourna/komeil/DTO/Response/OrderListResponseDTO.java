package ir.bourna.komeil.DTO.Response;

import ir.bourna.komeil.models.Enums.OrderStatus;
import ir.bourna.komeil.models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class OrderListResponseDTO {
    private Long id;
    private Set setAddress;
    private String description;
    private OrderStatus orderStatus;
    private List<HashMap<String,String>> productItems;

    private String username;
    private String phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set getSetAddress() {
        return setAddress;
    }

    public void setSetAddress(Set setAddress) {
        this.setAddress = setAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OrderStatus getOrderListStatus() {
        return orderStatus;
    }

    public void setOrderListStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<HashMap<String, String>> getProductItems() {
        return productItems;
    }

    public void setProductItems(List<HashMap<String, String>> productItems) {
        this.productItems = productItems;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
