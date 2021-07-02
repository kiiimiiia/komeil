package ir.bourna.komeil.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ir.bourna.komeil.models.intermediate.OrderListProductItemNumber;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "color")
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "hex")
    private String hex;
    @Column(name = "enable")
    private boolean enable;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "colors")
    private Set<ProductItem> productItemSet = new HashSet<>();
    @JsonIgnore
    @OneToMany(mappedBy = "color")
    private Set<OrderListProductItemNumber> orderListProductItemNumberSet = new HashSet<>();

    public Color() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ProductItem> getProductItemSet() {
        return productItemSet;
    }

    public void setProductItemSet(Set<ProductItem> productItemSet) {
        this.productItemSet = productItemSet;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
