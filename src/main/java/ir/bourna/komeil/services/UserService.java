package ir.bourna.komeil.services;

import ir.bourna.komeil.controllers.web.requests.AddAddressRequest;
import ir.bourna.komeil.controllers.web.requests.ConfirmOtpRequest;
import ir.bourna.komeil.controllers.web.requests.SignUpRequest;
import ir.bourna.komeil.controllers.web.requests.TicketRequest;
import ir.bourna.komeil.controllers.web.requests.passwordRequest;
import ir.bourna.komeil.controllers.web.responses.GetMobileResponse;
import ir.bourna.komeil.models.Address;
import ir.bourna.komeil.models.Ticket;
import ir.bourna.komeil.models.User;
import ir.bourna.komeil.utils.BaseResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    User getUserDetail(String mobile);
    void signUp(SignUpRequest request);
    void edit(SignUpRequest request);
    GetMobileResponse checkMobile(String mobile);
    String getOtpCode(String mobile);
    ResponseEntity<BaseResponse> confirmOtp(ConfirmOtpRequest confirmOtpRequest);
    ResponseEntity<Address> addAddress (AddAddressRequest addAddressRequest , String mobile);
    ResponseEntity<BaseResponse> sendTicket(TicketRequest request , String uid);
    List<Ticket> userTickets(String uid);

    ResponseEntity<BaseResponse> confirmpass(passwordRequest passwordRequest);

    ResponseEntity<BaseResponse> setpass(passwordRequest passwordRequest);
}
