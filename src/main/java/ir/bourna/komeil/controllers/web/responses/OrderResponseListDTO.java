package ir.bourna.komeil.controllers.web.responses;

import ir.bourna.komeil.DTO.Response.ProductItemResponseDTO;

public class OrderResponseListDTO {
    ProductItemResponseDTO productItemResponseDTO;
    int count;
String colorname;
    public ProductItemResponseDTO getProductItemResponseDTO() {
        return productItemResponseDTO;
    }

    public void setProductItemResponseDTO(ProductItemResponseDTO productItemResponseDTO) {
        this.productItemResponseDTO = productItemResponseDTO;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getColorname() {
        return colorname;
    }

    public void setColorname(String colorname) {
        this.colorname = colorname;
    }
}
