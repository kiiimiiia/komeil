package ir.bourna.komeil.config;

import com.google.gson.Gson;
import ir.bourna.komeil.DTO.Request.PaymentVerifyResquest;
import ir.bourna.komeil.DTO.Response.GetAccessTokenResponse;
import ir.bourna.komeil.DTO.Response.PaymentVerifyResponse;
import ir.bourna.komeil.models.Enums.OrderStatus;
import ir.bourna.komeil.models.OrderList;
import ir.bourna.komeil.models.Payment;
import ir.bourna.komeil.repositories.OrderListRepository;
import ir.bourna.komeil.repositories.PaymentRepository;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.util.Objects;

@Configuration
public class DargahConnection {
    @Autowired
    WebClient.Builder webclient;
    @Autowired
    OrderListRepository orderListRepository;
    @Autowired
    PaymentRepository paymentRepository;
     public GetAccessTokenResponse getAccessToken(Long orderlistid,String totalprice) throws IOException {
         OkHttpClient client = new OkHttpClient().newBuilder()
                 .build();
         MediaType mediaType = MediaType.parse("application/json");
         RequestBody body = RequestBody.create(mediaType, "{\n    \"Amount\":\""+totalprice+"\",\n\t \"callbackURL\":\"http://komeilshop.com:8081/web/v1/order/verify?orderLitsid="+orderlistid+"\",\n\t \"invoiceID\":\"611608572200953\",\n\t \"terminalID\":\"61001954\"\n\t \n}");
         System.out.println(body);
         Request request = new Request.Builder()
                 .url("https://mabna.shaparak.ir:8081/V1/PeymentApi/GetToken")
                 .method("POST", body)
                 .addHeader("Content-Type", "application/json")
                 .addHeader("Cookie", "cookiesession1=678A3E294ABCDEFGIJKLMNOPQRST680A")
                 .build();
         Response response = client.newCall(request).execute();

         String res = response.body().string();
         Gson gson = new Gson();
         GetAccessTokenResponse getAccessTokenResponse = gson.fromJson(res,GetAccessTokenResponse.class);
         Payment payment = new Payment();
         payment.setAccessToken(getAccessTokenResponse.getAccessToken());
         payment.setOrderListId(orderlistid);
         paymentRepository.save(payment);
        return getAccessTokenResponse;
     }

    public String  paymentVerify(Long id, PaymentVerifyResquest paymentVerifyResquest) throws IOException {
         Payment payment = paymentRepository.findByOrderListIdAndAmount(id,0);
        OrderList orderList = orderListRepository.findById(id).get();
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n    \"digitalreceipt\":\""+paymentVerifyResquest.getDigitalreceipt()+"\",\n\t \"Tid\":\"61001954\"\n\t \n}");
        Request request = new Request.Builder()
                .url("https://sepehr.shaparak.ir:8081/V1/PeymentApi/Advice")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Cookie", "cookiesession1=678A3E294ABCDEFGIJKLMNOPQRST680A")
                .build();
        Response response = client.newCall(request).execute();

        String res = response.body().string();
        Gson gson = new Gson();
        PaymentVerifyResponse paymentVerifyResponse = gson.fromJson(res,PaymentVerifyResponse.class);
        payment.setRespcode(paymentVerifyResquest.getRespcode());
        payment.setRespmsg(paymentVerifyResquest.getRespmsg());
        payment.setAmount(paymentVerifyResquest.getAmount());
        payment.setInvoiceid(paymentVerifyResquest.getInvoiceid());
        payment.setPayload(paymentVerifyResquest.getPayload());
        payment.setTerminalid(paymentVerifyResquest.getTerminalid());
        payment.setTracenumber(paymentVerifyResquest.getTracenumber());
        payment.setRrn(paymentVerifyResquest.getRrn());
        payment.setDatePaid(paymentVerifyResquest.getDatePaid());
        payment.setDigitalreceipt(paymentVerifyResquest.getDigitalreceipt());
        payment.setIssuerbank(paymentVerifyResquest.getIssuerbank());
        payment.setCardnumber(paymentVerifyResquest.getCardnumber());
        if(paymentVerifyResponse.getStatus()=="OK"){
        payment.setOrderStatus(OrderStatus.PAID);
        }
        else{
            payment.setOrderStatus(OrderStatus.FAIL);
        }
        paymentRepository.save(payment);
        orderList.setOrderStatus(OrderStatus.PAID);
        orderListRepository.save(orderList);
        if(Objects.equals(paymentVerifyResponse.getStatus(), "OK")){
            return "<div style=\"display: flex;justify-content: center; align-items: center;height: 100vh\">\n" +
                    "\n" +
                    "<div style=\" display: flex; align-items: center;background-color: rgb(127,127,127,0.2);width:350px;height: 450px;border-radius: 10px; flex-direction: column;\">\n" +
                    "  <img src=\"https://www.turandesign.com/images/success-icon.png\" style=\"width:90px;padding-top: 70px\"></img>\n" +
                    "<h3 style=\"color:   rgb(34,139,34);font-family:sans-serif;\">عملیات با موفقیت انجام شد</h3>\n" +
                    "<a href='http://komeilshop.com/profile/order'>\n" +
                    "<button style=\"width: 100px;height: 40px;border-radius: 15px ;border-style: solid;border-color: rgb(0,0,0,0.3);margin-top:100px\">بازگشت</button>\n" +
                    "</a>\n" +
                    "</div>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "</div>";
        }
        else{
           return "<div style=\"display: flex;justify-content: center; align-items: center;height: 100vh\">\n" +
                   "\n" +
                   "<div style=\" display: flex; align-items: center;background-color: rgb(127,127,127,0.2);width:350px;height: 450px;border-radius: 10px; flex-direction: column;\">\n" +
                   "  <img src=\"https://icons.veryicon.com/png/System/Amora/Delete.png\" style=\"width:90px;padding-top: 70px\"></img>\n" +
                   "<h3 style=\"color:   red;font-family:sans-serif;\">عملیات با موفقیت انجام نشد</h3>\n" +
                   "<a href='http://komeilshop.com'><button   style=\"width: 100px;height: 40px;border-radius: 15px ;border-style: solid;border-color: rgb(0,0,0,0.3);margin-top:100px\">بازگشت</button> </a>\n" +
                   "\n" +
                   "</div>\n" +
                   "\n" +
                   "\n" +
                   "\n" +
                   "\n" +
                   "\n" +
                   "\n" +
                   "</div>";
        }
    }
}
