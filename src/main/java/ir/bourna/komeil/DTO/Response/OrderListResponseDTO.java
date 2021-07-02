package ir.bourna.komeil.DTO.Response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ir.bourna.komeil.models.Enums.OrderListStatus;
import ir.bourna.komeil.models.ProductItem;
import ir.bourna.komeil.models.User;
import ir.bourna.komeil.models.intermediate.OrderListProductItemNumber;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class OrderListResponseDTO {
    private Long id;
    private Set setAddress;
    private String description;
    private OrderListStatus orderListStatus;
    private List<HashMap<String,String>> productItems;

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

    public OrderListStatus getOrderListStatus() {
        return orderListStatus;
    }

    public void setOrderListStatus(OrderListStatus orderListStatus) {
        this.orderListStatus = orderListStatus;
    }

    public List<HashMap<String, String>> getProductItems() {
        return productItems;
    }

    public void setProductItems(List<HashMap<String, String>> productItems) {
        this.productItems = productItems;
    }
}
