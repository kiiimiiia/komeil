package ir.bourna.komeil.models.intermediate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ir.bourna.komeil.models.Color;
import ir.bourna.komeil.models.ProductItem;

import javax.persistence.*;

@Entity
@Table(name = "product_item_color")
public class ProductitemColor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnoreProperties
    private Long id;
    @ManyToOne
    @JoinColumn(name = "product_item_id")
    private ProductItem productItem;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    @Column(name = "enable")
    private Boolean enable;

    @Column(name = "number")
    private Integer number ;

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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}

