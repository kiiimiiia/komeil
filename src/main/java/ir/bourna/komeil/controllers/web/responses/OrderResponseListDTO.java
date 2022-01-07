package ir.bourna.komeil.controllers.web.responses;

import ir.bourna.komeil.DTO.Response.ProductItemResponseDTO;

public class OrderResponseListDTO {
    Long id;
    ProductItemResponseDTO productItemResponseDTO;
    int count;
String colorname;
Long OrderListId;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderListId() {
        return OrderListId;
    }

    public void setOrderListId(Long orderListId) {
        OrderListId = orderListId;
    }
}
