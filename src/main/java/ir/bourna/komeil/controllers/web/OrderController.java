package ir.bourna.komeil.controllers.web;

import ir.bourna.komeil.DTO.Request.EditProductNumberInOrderList;
import ir.bourna.komeil.DTO.Request.PaymentVerifyResquest;
import ir.bourna.komeil.DTO.Response.BaseResponseDTO;
import ir.bourna.komeil.DTO.Response.GetAccessTokenResponse;
import ir.bourna.komeil.controllers.web.requests.CompeletOrderRequest;
import ir.bourna.komeil.controllers.web.requests.OrderSubmitRequest;
import ir.bourna.komeil.controllers.web.responses.OrderResponseListDTO;
import ir.bourna.komeil.models.Enums.OrderStatus;
import ir.bourna.komeil.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/web/v1/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @RequestMapping(value = "/submit/{phone}" ,  method = RequestMethod.POST)
    public BaseResponseDTO submitOrder(@RequestBody OrderSubmitRequest request , @PathVariable("phone") String phone){
       return orderService.submit(request , phone);
    }

    @RequestMapping(value = "/log/{phone}/{status}" , method = RequestMethod.GET)
    public ResponseEntity<List<OrderResponseListDTO>> getOrderLogs(@PathVariable("status") OrderStatus status, @PathVariable("phone") String phone){
      return orderService.getOrderLog(status , phone);
    }

    @RequestMapping(value = "/complete/{phone}" , method = RequestMethod.POST)
    public GetAccessTokenResponse completeOrder(@PathVariable("phone") String phone, @RequestBody CompeletOrderRequest request){
       return orderService.completeOrder(phone , request);
    }
    @RequestMapping(value = "/edit-number/{phone}" ,  method = RequestMethod.POST)
    public BaseResponseDTO editProductNumberInOrderList( @PathVariable("phone") String phone , @RequestBody EditProductNumberInOrderList request){
        return orderService.editProductNumberInOrderList( phone , request);
    }
    @RequestMapping(value = "/verify" ,  method = RequestMethod.POST)
    public String verifypeyment( @RequestParam("orderLitsid") Long id , @RequestBody PaymentVerifyResquest PaymentVerifyResquest){
        return orderService.verifypayment( id , PaymentVerifyResquest);
    }
}
