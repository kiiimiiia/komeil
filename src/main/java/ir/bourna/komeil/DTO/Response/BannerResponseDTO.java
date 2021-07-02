package ir.bourna.komeil.DTO.Response;

import ir.bourna.komeil.models.Banner;

public class BannerResponseDTO {
    private Long id;
    private String name;
    private String description;
    private Long productCategoryID;
    private String url;
    private Long categoryID;
private String categoryname;
private Banner.BannerType bannertype;
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

    public Long getProductCategoryID() {
        return productCategoryID;
    }

    public void setProductCategoryID(Long productCategoryID) {
        this.productCategoryID = productCategoryID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Long categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public Banner.BannerType getBannertype() {
        return bannertype;
    }

    public void setBannertype(Banner.BannerType bannertype) {
        this.bannertype = bannertype;
    }
}
