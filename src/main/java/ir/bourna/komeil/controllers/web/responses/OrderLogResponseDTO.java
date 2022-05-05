package ir.bourna.komeil.controllers.web.responses;

import ir.bourna.komeil.DTO.Response.ProductItemResponseDTO;
import ir.bourna.komeil.models.OrderList;

import java.util.List;

public class OrderLogResponseDTO {
    List<OrderResponseListDTO> productItemResponseDTOS;
    OrderList orderList;

    public List<OrderResponseListDTO> getProductItemResponseDTOS() {
        return productItemResponseDTOS;
    }

    public void setProductItemResponseDTOS(List<OrderResponseListDTO> productItemResponseDTOS) {
        this.productItemResponseDTOS = productItemResponseDTOS;
    }

    public OrderList getOrderList() {
        return orderList;
    }

    public void setOrderList(OrderList orderList) {
        this.orderList = orderList;
    }
}
