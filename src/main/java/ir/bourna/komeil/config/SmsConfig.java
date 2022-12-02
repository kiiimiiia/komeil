package ir.bourna.komeil.config;


import ir.bourna.komeil.controllers.web.requests.ParametrSendOtp;
import ir.bourna.komeil.controllers.web.requests.SendOtp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Random;


@Configuration
public class SmsConfig {
//    @Value("${kavenegar.sendUrl}")
//    private String kavenegarURL;
//    @Value("${kavenegar.templete}")
//    private String kavenegarTemplete;
//    @Value("${kavenegar.apiKey}")
//    private String apikey;
//    @Value("${kavenegar.senderline}")
//    private String senderline;

    @Autowired
    WebClient.Builder webclient;

    public String GenerateOtp() {
        Random random = new Random();
        int otp = 10000 + random.nextInt(90000);

        return  String.valueOf(otp);
    }
/*

    public GetSmsTokenDTO GetSmsToken() {
        String smsUrl = "https://RestfulSms.com/api/Token";

        String payload = "{\n\t\"UserApiKey\":\"5880165052c33b82435e1650\",\n\t\"SecretKey\":\"@r@sh#khosr@vi@ni&\"\n}\n";
        String headers = "{\n\t\"Content-Type\":\" application/json\" \n}\n";

        GetSmsTokenDTO getSmsTokenDTO;
        getSmsTokenDTO = webclient.build()
                .post()
                .uri(smsUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .header(headers)
                .body(BodyInserters.fromValue(payload))
                .retrieve().bodyToMono(GetSmsTokenDTO.class).block();

        return getSmsTokenDTO;
    }

*/

    public String SendSms(String phone, String text) {
        SendOtp sendOtp = new SendOtp();
        ParametrSendOtp parametrSendOtp = new ParametrSendOtp();
        ParametrSendOtp[] parametrSendOtps = new ParametrSendOtp[1];
        sendOtp.setMobile(phone);
        sendOtp.setTemplateId(888889);
        parametrSendOtp.setName("CODE");
        parametrSendOtp.setValue(text);
        parametrSendOtps[0]= parametrSendOtp;
        sendOtp.setParameters(parametrSendOtps);
        String sendurl = "https://api.sms.ir/v1/send/verify";
        String headers = "{\n\t\"Content-Type\":\" application/json\" \n}\n";
        String result = webclient.build()
                .post()
                .uri(sendurl)
                .contentType(MediaType.APPLICATION_JSON)
                .header(headers)
                .header("X-API-KEY", "8gsv4fQGjJvDugVRotxXi1cTtNfwQsVqal1WrU0nNLena4UPSRmNoF7WChyQN5li")
                .body(Mono.just(sendOtp), SendOtp.class)
                .retrieve().bodyToMono(String.class).block();

        return result;

    }

    public String SendSuccessSms(String phone, String text) {
        SendOtp sendOtp = new SendOtp();
        ParametrSendOtp parametrSendOtp = new ParametrSendOtp();
        ParametrSendOtp[] parametrSendOtps = new ParametrSendOtp[1];
        sendOtp.setMobile(phone);
        sendOtp.setTemplateId(148267);
        parametrSendOtp.setName("CODE");
        parametrSendOtp.setValue(text);
        parametrSendOtps[0]= parametrSendOtp;
        sendOtp.setParameters(parametrSendOtps);
        String sendurl = "https://api.sms.ir/v1/send/verify";
        String headers = "{\n\t\"Content-Type\":\" application/json\" \n}\n";
        String result = webclient.build()
                .post()
                .uri(sendurl)
                .contentType(MediaType.APPLICATION_JSON)
                .header(headers)
                .header("X-API-KEY", "8gsv4fQGjJvDugVRotxXi1cTtNfwQsVqal1WrU0nNLena4UPSRmNoF7WChyQN5li")
                .body(Mono.just(sendOtp), SendOtp.class)
                .retrieve().bodyToMono(String.class).block();

        return result;

    }

}
