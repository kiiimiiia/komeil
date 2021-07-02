package ir.bourna.komeil.controllers.web.responses;

import ir.bourna.komeil.models.Banner;
import ir.bourna.komeil.models.Enums.BannerType;

public class BannerResponseDTO {
    Banner.BannerType bannerType;
    String imageUrl;
    String categoryName;
    Long categoryId;


    public Banner.BannerType getBannerType() {
        return bannerType;
    }

    public void setBannerType(Banner.BannerType bannerType) {
        this.bannerType = bannerType;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
