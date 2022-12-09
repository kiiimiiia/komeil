package ir.bourna.komeil.DTO.Response;

import ir.bourna.komeil.models.Banner;
import ir.bourna.komeil.models.ProductItem;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductCategoryResponseDTO {
    private Long id;
    private String name;
    private boolean enable;
    private String imageUrl;
    private String parentName;
    private String descriptionMetatag;
    private String canonicalMetatag;
    private String titleMetatag;
//    private Long productItemID;
//    private Object[]bannersID;

//    public Long getProductItemID() {
//        return productItemID;
//    }
//
//    public void setProductItemID(Long productItemID) {
//        this.productItemID = productItemID;
//    }

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

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
//    public Object[] getBannersID() {
//        return bannersID;
//    }
//
//    public void setBannersID(Object[] bannersID) {
//        this.bannersID = bannersID;
//    }


    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
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
