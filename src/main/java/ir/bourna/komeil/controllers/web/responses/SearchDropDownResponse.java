package ir.bourna.komeil.controllers.web.responses;

public class SearchDropDownResponse {
    public String productName ;
    public  String productHash;
    public String categoryName;

    public SearchDropDownResponse(String productName, String productHash, String categoryName) {
        this.productName = productName;
        this.productHash = productHash;
        this.categoryName = categoryName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductHash() {
        return productHash;
    }

    public void setProductHash(String productHash) {
        this.productHash = productHash;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
