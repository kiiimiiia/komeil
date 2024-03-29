package ir.bourna.komeil.DTO.Response;

import ir.bourna.komeil.models.*;
import ir.bourna.komeil.models.intermediate.OrderListProductItemNumber;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductItemResponseDTO {

    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private Integer netPrice;
    private Integer discount;
    private Long stock;
    private Integer rate;
    private Set<Color> colors = new HashSet<>();
    private Long brandID;
    private Long productCategoryID;
    private String altImg;
    private String categoryname;
    private Set<ProductAdditionalImage> productAdditionalImages = new HashSet<>();
    private String Hash;
private String brandname;
    private Set<Long> orderListProductItemNumberSet;
private List<Color> colorsList;
    private Boolean enable;
    private String productWidth;
    private String descriptionMetatag;
    private String canonicalMetatag;
    private String titleMetatag;
    private String productLength;
    private String productHeight;
    private String boxWidth;
    private String boxLength;
    private String boxHeight;
    private AmazingOffer amazingOffer;
    private String material;
    private String count;
    private boolean have;
    private String weight;
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

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
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

    public Set<Color> getColors() {
        return colors;
    }

    public void setColors(Set<Color> colors) {
        this.colors = colors;
    }

    public Long getBrandID() {
        return brandID;
    }

    public void setBrandID(Long brandID) {
        this.brandID = brandID;
    }

    public Long getProductCategoryID() {
        return productCategoryID;
    }

    public void setProductCategoryID(Long productCategoryID) {
        this.productCategoryID = productCategoryID;
    }

    public Set<ProductAdditionalImage> getProductAdditionalImages() {
        return productAdditionalImages;
    }

    public void setProductAdditionalImages(Set<ProductAdditionalImage> productAdditionalImages) {
        this.productAdditionalImages = productAdditionalImages;
    }

    public Set<Long> getOrderListProductItemNumberSet() {
        return orderListProductItemNumberSet;
    }

    public void setOrderListProductItemNumberSet(Set<Long> orderListProductItemNumberSet) {
        this.orderListProductItemNumberSet = orderListProductItemNumberSet;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public AmazingOffer getAmazingOffer() {
        return amazingOffer;
    }

    public void setAmazingOffer(AmazingOffer amazingOffer) {
        this.amazingOffer = amazingOffer;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    public String getHash() {
        return Hash;
    }

    public void setHash(String hash) {
        Hash = hash;
    }

    public List<Color> getColorsList() {
        return colorsList;
    }

    public void setColorsList(List<Color> colorsList) {
        this.colorsList = colorsList;
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

    public boolean isHave() {
        return have;
    }

    public void setHave(boolean have) {
        this.have = have;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getDescriptionMetatag() {
        return descriptionMetatag;
    }

    public void setDescriptionMetatag(String descriptionMetatag) {
        this.descriptionMetatag = descriptionMetatag;
    }

    public String getCanonicalMetatag() {
        return canonicalMetatag;
    }

    public void setCanonicalMetatag(String canonicalMetatag) {
        this.canonicalMetatag = canonicalMetatag;
    }

    public String getTitleMetatag() {
        return titleMetatag;
    }

    public void setTitleMetatag(String titleMetatag) {
        this.titleMetatag = titleMetatag;
    }

    public String getAltImg() {
        return altImg;
    }

    public void setAltImg(String altImg) {
        this.altImg = altImg;
    }
}
