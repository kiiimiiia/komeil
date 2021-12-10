package ir.bourna.komeil.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import ir.bourna.komeil.models.intermediate.OrderListProductItemNumber;
import ir.bourna.komeil.models.intermediate.ProductitemColor;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "product_item")
public class ProductItem extends AuditModel{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;
        @Column(name = "name")
        private String name;
        @Column(name = "description")
        private String description;
        @Column(name = "image_url")
        private String imageUrl;

        @Column(name = "net_price")
        private Integer netPrice;
        @Column(name = "discount")
        private Integer discount;
        @Column(name = "hashproduct")
        private String hashproduct;

        @Column(name = "product_width")
        private String productWidth;

        @Column(name = "product_length")
        private String productLength;

        @Column(name = "product_height")
        private String productHeight;

        @Column(name = "box_width")
        private String boxWidth;

        @Column(name = "box_length")
        private String boxLength;

        @Column(name = "box_height")
        private String boxHeight;

        @Column(name = "weight")
        private String weight;

        @Column(name = "have")
        private Boolean have;

        @Column(name = "stock")
        private Long stock;
        @Column(name = "rate")
        private Integer rate;
        @Column(name = "brand_id")
        private Long brandId;
        @JsonIgnore
        @OneToMany(mappedBy = "productItem")
        private Set<ProductitemColor> productitemColors = new HashSet<>();



        @Column(name = "category_id")
        private Long productCategory;
        @JsonIgnore
        @OneToMany(mappedBy = "productItem")
        private Set<ProductAdditionalImage> productAdditionalImages = new HashSet<>();

        @OneToMany(mappedBy = "productItem")
        private Set<OrderListProductItemNumber> orderListProductItemNumberSet;

        @Column(name = "enable")
        private Boolean enable;



//        @ManyToMany(fetch = FetchType.LAZY,
//                cascade = {
//                        CascadeType.PERSIST,
//                        CascadeType.MERGE
//                },
//                mappedBy = "orderListList")
//        private Set<Post> posts = new HashSet<>();


        public ProductItem() {
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

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public String getImageUrl() {
                return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
        }

        public Integer getNetPrice() {
                return netPrice;
        }

        public void setNetPrice(Integer netPrice) {
                this.netPrice = netPrice;
        }

        public Integer getDiscount() {
                return discount;
        }

        public void setDiscount(Integer discount) {
                this.discount = discount;
        }


        public Long getStock() {
                return stock;
        }

        public void setStock(Long stock) {
                this.stock = stock;
        }

        public Integer getRate() {
                return rate;
        }

        public void setRate(Integer rate) {
                this.rate = rate;
        }

        public Set<ProductAdditionalImage> getProductAdditionalImages() {
                return productAdditionalImages;
        }

        public void setProductAdditionalImages(Set<ProductAdditionalImage> productAdditionalImages) {
                this.productAdditionalImages = productAdditionalImages;
        }


        public Long getProductCategory() {
                return productCategory;
        }

        public void setProductCategory(Long productCategory) {
                this.productCategory = productCategory;
        }

        public Boolean getEnable() {
                return enable;
        }

        public void setEnable(Boolean enable) {
                this.enable = enable;
        }

        public Set<ProductitemColor> getProductitemColors() {
                return productitemColors;
        }

        public void setProductitemColors(Set<ProductitemColor> productitemColors) {
                this.productitemColors = productitemColors;
        }

        public Set<OrderListProductItemNumber> getOrderListProductItemNumberSet() {
                return orderListProductItemNumberSet;
        }

        public void setOrderListProductItemNumberSet(Set<OrderListProductItemNumber> orderListProductItemNumberSet) {
                this.orderListProductItemNumberSet = orderListProductItemNumberSet;
        }

        public Long getBrandId() {
                return brandId;
        }

        public void setBrandId(Long brandId) {
                this.brandId = brandId;
        }

        public String getHashproduct() {
                return hashproduct;
        }

        public void setHashproduct(String hashproduct) {
                this.hashproduct = hashproduct;
        }

        public String getProductWidth() {
                return productWidth;
        }

        public void setProductWidth(String productWidth) {
                this.productWidth = productWidth;
        }

        public String getProductLength() {
                return productLength;
        }

        public void setProductLength(String productLength) {
                this.productLength = productLength;
        }

        public String getProductHeight() {
                return productHeight;
        }

        public void setProductHeight(String productHeight) {
                this.productHeight = productHeight;
        }

        public String getBoxWidth() {
                return boxWidth;
        }

        public void setBoxWidth(String boxWidth) {
                this.boxWidth = boxWidth;
        }

        public String getBoxLength() {
                return boxLength;
        }

        public void setBoxLength(String boxLength) {
                this.boxLength = boxLength;
        }

        public String getBoxHeight() {
                return boxHeight;
        }

        public void setBoxHeight(String boxHeight) {
                this.boxHeight = boxHeight;
        }

        public Boolean getHave() {
                return have;
        }

        public void setHave(Boolean have) {
                this.have = have;
        }

        public String getWeight() {
                return weight;
        }

        public void setWeight(String weight) {
                this.weight = weight;
        }
}
