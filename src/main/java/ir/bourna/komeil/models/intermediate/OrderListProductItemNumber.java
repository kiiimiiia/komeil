package ir.bourna.komeil.models.intermediate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ir.bourna.komeil.models.Color;
import ir.bourna.komeil.models.OrderList;
import ir.bourna.komeil.models.ProductItem;

import javax.persistence.*;


@Entity
public class OrderListProductItemNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnoreProperties
    private Long id;
    @ManyToOne
    @JoinColumn(name = "product_item_id")
    private ProductItem productItem;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "order_list_id")
    private OrderList orderList;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    private int number;

    public OrderListProductItemNumber() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductItem getProductItem() {
        return productItem;
    }

    public void setProductItem(ProductItem productItem) {
        this.productItem = productItem;
    }

    public OrderList getorderList() {
        return orderList;
    }

    public void setorderList(OrderList orderList) {
        this.orderList = orderList;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public OrderList getOrderList() {
        return orderList;
    }

    public void setOrderList(OrderList orderList) {
        this.orderList = orderList;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}