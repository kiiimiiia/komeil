package ir.bourna.komeil.DTO.Response;

import ir.bourna.komeil.models.ProductItem;

public class BrandResponseDTO {
    private Long id;
    private String title;
    private String imageUrl;
    private String description;
    private Long productItemID;
private boolean enable;
private boolean vip;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getProductItemID() {
        return productItemID;
    }

    public void setProductItemID(Long productItemID) {
        this.productItemID = productItemID;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }
}
