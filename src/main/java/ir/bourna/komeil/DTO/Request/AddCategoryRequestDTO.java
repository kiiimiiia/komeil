package ir.bourna.komeil.DTO.Request;


public class AddCategoryRequestDTO {

    private String name;
    private String imageUrl;
    private Integer parentCategory;
    private String descriptionMetatag;
    private String canonicalMetatag;
    private String titleMetatag;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Integer parentCategory) {
        this.parentCategory = parentCategory;
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
}
