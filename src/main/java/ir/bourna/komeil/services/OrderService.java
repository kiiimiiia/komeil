package ir.bourna.komeil.services;

import ir.bourna.komeil.DTO.Request.EditProductNumberInOrderList;
import ir.bourna.komeil.DTO.Request.PaymentVerifyResquest;
import ir.bourna.komeil.DTO.Response.BaseResponseDTO;
import ir.bourna.komeil.DTO.Response.GetAccessTokenResponse;
import ir.bourna.komeil.controllers.web.requests.CompeletOrderRequest;
import ir.bourna.komeil.controllers.web.requests.OrderSubmitRequest;
import ir.bourna.komeil.controllers.web.responses.OrderResponseListDTO;
import ir.bourna.komeil.models.Enums.OrderStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {
    BaseResponseDTO submit(OrderSubmitRequest request , String phone);
    ResponseEntity<List<OrderResponseListDTO>> getOrderLog(OrderStatus status, String phone);
    GetAccessTokenResponse completeOrder(String phone , CompeletOrderRequest request);

    BaseResponseDTO editProductNumberInOrderList(String phone, EditProductNumberInOrderList request);

    String  verifypayment(Long id, PaymentVerifyResquest paymentVerifyResquest);
}
