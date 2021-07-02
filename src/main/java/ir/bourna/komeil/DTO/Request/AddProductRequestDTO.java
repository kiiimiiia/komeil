package ir.bourna.komeil.DTO.Request;


import ir.bourna.komeil.models.Brand;

import java.util.List;

public class AddProductRequestDTO {

    private String name;
    private String description;
    private String imageUrl;
    private Double netPrice;
    private Integer discount;
    private Long stock;
    private Long brandId;
    private Long categoryId;
    private String[] additinoalimage;
private Long[] colorid;
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

    public Double getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(Double netPrice) {
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

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long[] getColorid() {
        return colorid;
    }

    public void setColorid(Long[] colorid) {
        this.colorid = colorid;
    }

    public String[] getAdditinoalimage() {
        return additinoalimage;
    }

    public void setAdditinoalimage(String[] additinoalimage) {
        this.additinoalimage = additinoalimage;
    }
}
