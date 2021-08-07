package ir.bourna.komeil.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ir.bourna.komeil.models.Enums.BannerType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "banner")
public class Banner extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "image_url")
    private String imageUrl;
    @Enumerated(EnumType.STRING)
    private BannerType bannerType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_category_id",  nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private ProductCategory category;

    public Banner() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BannerType getBannerType() {
        return bannerType;
    }

    public void setBannerType(BannerType bannerType) {
        this.bannerType = bannerType;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }
public enum BannerType {
        firstbanner_landing,
    secondbanner_landing,
    thirdbanner_landing,
    fourthbanner_landing,
    fifthbanner_landing,
    sixthbanner_landing,
    seventhbanner_landing,
    firstbanner_stock,
    secondbanner_stock,
    fisrtbanner_aboutus,
    secondbanner_aboutus,
    thirdbanner_aboutus,
    fourthbanner_aboutus,
    fifthbanner_aboutus,
    sixthbanner_aboutus,
    seventhbanner_aboutus,
    firstbanner_blog,
    secondbanner_blog
    }
}


