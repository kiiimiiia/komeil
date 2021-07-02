package ir.bourna.komeil.DTO.Request;

import ir.bourna.komeil.models.Banner;
import ir.bourna.komeil.models.Brand;

public class AddBannerRequestDTO {
    private String name;
    private String description;
    private String url;
    private Long categoryId;
    private Banner.BannerType type;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Banner.BannerType getType() {
        return type;
    }

    public void setType(Banner.BannerType type) {
        this.type = type;
    }
}
