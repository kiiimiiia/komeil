package ir.bourna.komeil.services;

//import com.kavenegar.sdk.KavenegarApi;
//import com.kavenegar.sdk.excepctions.ApiException;
//import com.kavenegar.sdk.excepctions.HttpException;
//import com.kavenegar.sdk.models.SendResult;
import ir.bourna.komeil.config.SmsConfig;
import ir.bourna.komeil.controllers.web.requests.AddAddressRequest;
import ir.bourna.komeil.controllers.web.requests.ConfirmOtpRequest;
import ir.bourna.komeil.controllers.web.requests.SignUpRequest;
import ir.bourna.komeil.controllers.web.requests.TicketRequest;
import ir.bourna.komeil.controllers.web.requests.passwordRequest;
import ir.bourna.komeil.controllers.web.responses.GetMobileResponse;
import ir.bourna.komeil.models.Address;
import ir.bourna.komeil.models.Enums.OtpStatus;
import ir.bourna.komeil.models.Enums.TicketStatus;
import ir.bourna.komeil.models.Otp;
import ir.bourna.komeil.models.Ticket;
import ir.bourna.komeil.models.User;
import ir.bourna.komeil.repositories.AddressRepository;
import ir.bourna.komeil.repositories.OtpRepository;
import ir.bourna.komeil.repositories.TicketRepository;
import ir.bourna.komeil.repositories.UserRepository;
import ir.bourna.komeil.utils.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImp implements UserService{
    final private UserRepository userRepository;
    final private OtpRepository otpRepository;
    final private TicketRepository ticketRepository;
    @Autowired
    SmsConfig smsConfig;
@Autowired
    AddressRepository addressRepository;

    @Autowired
    public UserServiceImp(
            UserRepository userRepository,
            OtpRepository otpRepository,
            TicketRepository ticketRepository
    ){
        this.userRepository = userRepository;
        this.otpRepository = otpRepository;
        this.ticketRepository = ticketRepository;
    }

    public  User getUserDetail(String mobile){
        return userRepository.findByMobile(mobile);
    }

    public void signUp(SignUpRequest request){
        User user = new User(request.getFirstName(),request.getLastName(),request.getEmail(),request.getMobile());
        userRepository.save(user);
    }

    public void edit(SignUpRequest request ){
        User user  = userRepository.findByMobile(request.getMobile());

        if (request.getFirstName() != null)
            user.setFirstName(request.getFirstName());
        if (request.getLastName() != null)
            user.setLastName(request.getLastName());
        if (request.getEmail() != null)
            user.setEmail(request.getEmail());


        userRepository.save(user);
    }

    @Override
    public GetMobileResponse checkMobile(String mobile){
        GetMobileResponse getMobileResponseDTO = new GetMobileResponse();
        User user = userRepository.findByMobile(mobile);
        if (user != null) {

            getMobileResponseDTO.setRegistered(true);
            getMobileResponseDTO.setBlock(user.getEnable());

        } else {
            getMobileResponseDTO.setRegistered(false);
            getMobileResponseDTO.setBlock(false);
            User userEntity1 = new User();
            userEntity1.setMobile(mobile);
            long currentTimestamp = System.currentTimeMillis();
            userEntity1.setCreatedAt(currentTimestamp);
            userEntity1.setUpdatedAt(currentTimestamp);
            userRepository.save(userEntity1);
        }
        return getMobileResponseDTO;

    }

    @Override
    public String getOtpCode(String mobile){


            final String generate =smsConfig.GenerateOtp();
        String res = smsConfig.SendSms(mobile,generate);

        Otp otp = otpRepository.findByMobileAndStatus(mobile, OtpStatus.GENERATED);
            if (otp != null) {
                otp.setCode(generate);
                otpRepository.save(otp);
            } else {
                Otp otp1 = new Otp();
                otp1.setMobile(mobile);
                otp1.setCode(generate);
                otp1.setStatus( OtpStatus.GENERATED);
                otpRepository.save(otp1);
            }


        return res;


    }
    public ResponseEntity<BaseResponse> confirmOtp(ConfirmOtpRequest confirmOtpRequest){
        Otp otp = otpRepository.findByMobileAndStatus(confirmOtpRequest.getMobile(), OtpStatus.GENERATED);
        if (otp == null) {
            return ResponseEntity.badRequest().body(new BaseResponse(400,"شما ثبت نام نکرده اید"));
        }
        else {
            if (confirmOtpRequest.getCode().equals(otp.getCode())) {
                otp.setStatus(OtpStatus.USED);
                otpRepository.save(otp);
                return ResponseEntity.ok().body(new BaseResponse(200 , "کد شما صحیح است"));
            } else {
                return ResponseEntity.badRequest().body(new BaseResponse(400 , "کد شما صحیح نیست" ));
            }
        }

    }

    @Override
    public ResponseEntity<BaseResponse> confirmpass(passwordRequest passwordRequest) {
        User user =userRepository.findByMobile(passwordRequest.getMobile());
        if(user.getPassword().equals(passwordRequest.getPassword()))
            return ResponseEntity.ok().body(new BaseResponse(200 , "صحیح است."));
        else
            return ResponseEntity.ok().body(new BaseResponse(400 , "صحیح نیست."));
    }

    @Override
    public ResponseEntity<BaseResponse> setpass(passwordRequest passwordRequest) {
        User user =userRepository.findByMobile(passwordRequest.getMobile());
        user.setPassword(passwordRequest.getPassword());
        userRepository.save(user);
        return ResponseEntity.ok().body(new BaseResponse(200 , "با موفقیت ثبت شد."));
    }

    @Override
    public List<Address> address(String mobile) {
        User user = userRepository.findByMobile(mobile);
        List<Address>addresses=addressRepository.findAllByUser(user);
        return addresses;
    }

    @Override
    public ResponseEntity<Address> addAddress (AddAddressRequest addAddressRequest , String mobile){
        User user  = userRepository.findByMobile(mobile);
        Address address =new Address();
        address.setPostalcode(addAddressRequest.getCodeposti());
        address.setDes(addAddressRequest.getDes());
        address.setUser(user);
        address.setCreatedAt(System.currentTimeMillis() / 1000);
        address.setUpdatedAt(System.currentTimeMillis() / 1000);
        return ResponseEntity.ok(addressRepository.save(address));
    }

    @Override
    public ResponseEntity<BaseResponse> sendTicket(TicketRequest request , String mobile){
        User user  = userRepository.findByMobile(mobile);
        if(user == null)
        {
            return ResponseEntity.ok().body(new BaseResponse(404 , "کاربر یافت نشد"));

        }
        Ticket ticket = new Ticket();
        ticket.setUser(user);
        ticket.setCreatedAt(System.currentTimeMillis() / 1000);
        ticket.setUpdatedAt(System.currentTimeMillis() / 1000);
        ticket.setContent(request.getTicketContext());
        ticket.setTicketStatus(TicketStatus.Question);
        ticketRepository.save(ticket);
        return ResponseEntity.ok().body(new BaseResponse(200 , "تیکت با موفقیت ارسال شد."));

    }


    @Override
    public List<Ticket> userTickets( String mobile){
        User user  = userRepository.findByMobile(mobile);
        if(user == null)
        {
            return new ArrayList<>();
        }
        return ticketRepository.findAllByUser(user);
    }

}
