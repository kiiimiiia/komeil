package ir.bourna.komeil.models;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "amazing_offer")
public class AmazingOffer extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "start_date", nullable = false, updatable = true)
    private Long startDate;

    @Column(name = "end_date", nullable = false, updatable = true)
    private Long endDate;


    @Column(name = "product_item_id")
    private Long productItem;

    public AmazingOffer() {
    }

    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public Long getEndDate() {
        return endDate;
    }

    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }

    public Long getProductItem() {
        return productItem;
    }

    public void setProductItem(Long productItem) {
        this.productItem = productItem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
