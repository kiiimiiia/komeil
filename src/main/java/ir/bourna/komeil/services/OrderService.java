package ir.bourna.komeil.services;

import ir.bourna.komeil.DTO.Response.BaseResponseDTO;
import ir.bourna.komeil.DTO.Response.ProductItemResponseDTO;
import ir.bourna.komeil.controllers.web.requests.CompeletOrderRequest;
import ir.bourna.komeil.controllers.web.requests.OrderSubmitRequest;
import ir.bourna.komeil.controllers.web.responses.OrderResponseListDTO;
import ir.bourna.komeil.models.Enums.OrderListStatus;
import ir.bourna.komeil.models.OrderList;
import ir.bourna.komeil.models.ProductItem;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {
    BaseResponseDTO submit(OrderSubmitRequest request , String phone);
    ResponseEntity<List<OrderResponseListDTO>> getOrderLog(OrderListStatus status, String phone);
    void completeOrder(String phone , CompeletOrderRequest request);

}
