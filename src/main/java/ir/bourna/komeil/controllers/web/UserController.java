package ir.bourna.komeil.controllers.web;

import io.swagger.models.Response;
import ir.bourna.komeil.controllers.web.requests.*;
import ir.bourna.komeil.controllers.web.responses.GetMobileResponse;
import ir.bourna.komeil.models.Address;
import ir.bourna.komeil.models.Ticket;
import ir.bourna.komeil.models.User;
import ir.bourna.komeil.services.UserService;
import ir.bourna.komeil.services.UserServiceImp;
import ir.bourna.komeil.utils.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/web/v1/user")
public class UserController {
    final private  UserService userService;

    @Autowired
    public UserController(
            UserService userService
    ){
        this.userService = userService;
    }

    @RequestMapping(value = "/detail" , method = RequestMethod.GET)
    public User userDetail(@RequestParam("mobile") String mobile){
        return userService.getUserDetail(mobile);
    }


    @RequestMapping(value = "/sign-up" , method = RequestMethod.POST)
    public void signUp(@RequestBody SignUpRequest request){
        userService.signUp(request);
    }

    @RequestMapping(value = "/edit" , method = RequestMethod.PUT)
    public void edit(@RequestBody SignUpRequest request  ){
        userService.edit(request);
    }

    @RequestMapping(value = "/address" , method = RequestMethod.POST)
    public ResponseEntity<Address> edit(@RequestBody AddAddressRequest request  , @RequestParam("mobile") String mobile){
        return userService.addAddress(request , mobile);
    }

    @RequestMapping(value = "/mobile" , method = RequestMethod.POST)
    public GetMobileResponse checkMobile(@RequestBody GetMobileRequest getMobileRequestDTO) {
        return userService.checkMobile(getMobileRequestDTO.getMobile());
    }

    @PostMapping("/otp")
    public String getOtp(@RequestBody GetMobileRequest getMobileRequestDTO) {
        return userService.getOtpCode(getMobileRequestDTO.getMobile());
    }

    @PostMapping("/confirmOtp")
    private ResponseEntity<BaseResponse> confirmOtp(@RequestBody ConfirmOtpRequest confirmOtpRequest) {
        return userService.confirmOtp(confirmOtpRequest);
    }
    @PostMapping("/confirmpass")
    private ResponseEntity<BaseResponse> confirmpass(@RequestBody passwordRequest passwordRequest) {
        return userService.confirmpass(passwordRequest);
    }
    @PostMapping("/setpass")
    private ResponseEntity<BaseResponse> setpass(@RequestBody passwordRequest passwordRequest) {
        return userService.setpass(passwordRequest);
    }
    @RequestMapping(value = "/ticket" , method = RequestMethod.POST)
    public ResponseEntity<BaseResponse> sendTicket(@RequestBody TicketRequest request , @RequestParam("mobile") String mobile ){
        return userService.sendTicket(request , mobile);
    }

    @RequestMapping(value = "/ticket" , method = RequestMethod.GET)
    public List<Ticket> getTickets(  @RequestParam("mobile") String mobile){
        return userService.userTickets(mobile);
    }


}
