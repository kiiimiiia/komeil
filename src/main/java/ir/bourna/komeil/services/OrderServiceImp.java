package ir.bourna.komeil.services;

import ir.bourna.komeil.DTO.Request.EditProductNumberInOrderList;
import ir.bourna.komeil.DTO.Request.PaymentVerifyResquest;
import ir.bourna.komeil.DTO.Response.BaseResponseDTO;
import ir.bourna.komeil.DTO.Response.GetAccessTokenResponse;
import ir.bourna.komeil.DTO.Response.ProductItemResponseDTO;
import ir.bourna.komeil.config.DargahConnection;
import ir.bourna.komeil.controllers.web.requests.CompeletOrderRequest;
import ir.bourna.komeil.controllers.web.requests.OrderSubmitRequest;
import ir.bourna.komeil.controllers.web.responses.OrderResponseListDTO;
import ir.bourna.komeil.models.*;
import ir.bourna.komeil.models.Enums.OrderStatus;
import ir.bourna.komeil.models.intermediate.OrderListProductItemNumber;
import ir.bourna.komeil.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class OrderServiceImp implements OrderService {
    private final UserRepository userRepository;
    private final OrderListRepository orderListRepository;
    private final ProductItemRepository productItemRepository;
    private final OrderListProductItemNumberRepository orderListProductItemNumberRepository;
    private final TransportRepository transportRepository;
    private final ColorRepository colorRepository;
    @Autowired
  DargahConnection dargahConnection;
    public  OrderServiceImp(UserRepository userRepository , OrderListRepository orderListRepository , ProductItemRepository productItemRepository , OrderListProductItemNumberRepository orderListProductItemNumberRepository , TransportRepository transportRepository , ColorRepository colorRepository
    ){
        this.orderListRepository = orderListRepository;
        this.userRepository = userRepository;
        this.productItemRepository = productItemRepository;
        this.orderListProductItemNumberRepository = orderListProductItemNumberRepository;
        this.transportRepository = transportRepository;
        this.colorRepository = colorRepository;
    }

    @Override
    public BaseResponseDTO submit(OrderSubmitRequest request , String phone){
        User user  = userRepository.findByMobile(phone);
        if( user == null){
            return null;
        }
        Optional<ProductItem> productItem = productItemRepository.findById(request.getPid());
        if (!productItem.isPresent())
            return null;
        Color color =colorRepository.findById(0L).get();
        if(request.getColorId()!=null){
            color= colorRepository.findById(request.getColorId()).get();
        }
//        if (!productItem.get().getColors().contains(color.get()))
//            return null;
        OrderList orderList = orderListRepository.findAllByOrderStatusAndUser(OrderStatus.NOT_PAID , user);
        if (orderList == null){
            orderList = new OrderList();
            orderList.setUser(user);
            orderList.setCreatedAt(System.currentTimeMillis() / 1000);
            orderList.setUpdatedAt(System.currentTimeMillis() / 1000);
            orderList.setOrderStatus(OrderStatus.NOT_PAID);
            orderList = orderListRepository.save(orderList);
        }

        Set<OrderListProductItemNumber> productItemNumberSetset= orderList.getOrderListProductItemNumberSet();
        List<OrderListProductItemNumber>productItemNumberSet=new ArrayList<>(productItemNumberSetset);
        if(productItemNumberSet.size()==0){
            OrderListProductItemNumber orderListProductItemNumber = new OrderListProductItemNumber();
            orderListProductItemNumber.setProductItem(productItem.get());
            orderListProductItemNumber.setNumber(request.getNumber());
            orderListProductItemNumber.setorderList(orderList);
            orderListProductItemNumber.setColor(color);
            productItemNumberSet.add(orderListProductItemNumber);
            orderListProductItemNumberRepository.save(orderListProductItemNumber);
        }
        else{
            for(int i=0; i<productItemNumberSet.size();i++){
                if (request.getPid() == productItemNumberSet.get(i).getProductItem().getId()){
                    int number = productItemNumberSet.get(i).getNumber();
                    productItemNumberSet.get(i).setNumber(number+request.getNumber());
                    break;
                }
                if (i == productItemNumberSet.size()-1){
                    OrderListProductItemNumber orderListProductItemNumber = new OrderListProductItemNumber();
                    orderListProductItemNumber.setProductItem(productItem.get());
                    orderListProductItemNumber.setNumber(request.getNumber());
                    orderListProductItemNumber.setorderList(orderList);
                    orderListProductItemNumber.setColor(color);
                    productItemNumberSet.add(orderListProductItemNumber);
                    orderListProductItemNumberRepository.save(orderListProductItemNumber);

                }
            }
        }
        Set<OrderListProductItemNumber>res=new HashSet<>();
        for(OrderListProductItemNumber op : productItemNumberSet)
            res.add(op);
        orderList.setOrderListProductItemNumberSet(res);
//        orderList.setOrderListStatus(OrderListStatus.NOT_PAID);
        orderListRepository.save(orderList);
        BaseResponseDTO baseResponseDTO =new BaseResponseDTO();
        baseResponseDTO.setMessage("با موفقیت ثبت شد");
        baseResponseDTO.setCode(200);
        return baseResponseDTO;
    }

    @Override
    public ResponseEntity<List<OrderResponseListDTO>> getOrderLog(OrderStatus status, String phone){
        User user  = userRepository.findByMobile(phone);
        if(user == null){
            return null;
        }
      OrderList orderList =  orderListRepository.findAllByOrderStatusAndUser(status,user);
        Set<OrderListProductItemNumber> OrderListProductItemNumber= orderList.getOrderListProductItemNumberSet();

        List<OrderResponseListDTO> orderResponseListDTOS = new ArrayList<>();
        for (Iterator<OrderListProductItemNumber> it = OrderListProductItemNumber.iterator(); it.hasNext(); ) {
            OrderListProductItemNumber f = it.next();
            ProductItemResponseDTO productItemResponseDTO = new ProductItemResponseDTO();
            productItemResponseDTO.setId(f.getProductItem().getId());
            productItemResponseDTO.setDescription(f.getProductItem().getDescription());
            productItemResponseDTO.setDiscount(f.getProductItem().getDiscount());
            productItemResponseDTO.setNetPrice(f.getProductItem().getNetPrice());
            productItemResponseDTO.setRate(f.getProductItem().getRate());
            productItemResponseDTO.setStock(f.getProductItem().getStock());
            productItemResponseDTO.setHash(f.getProductItem().getHashproduct());
            productItemResponseDTO.setImageUrl(f.getProductItem().getImageUrl());
            productItemResponseDTO.setName(f.getProductItem().getName());
            int count = f.getNumber();
            OrderResponseListDTO orderResponseListDTO = new OrderResponseListDTO();
            orderResponseListDTO.setProductItemResponseDTO(productItemResponseDTO);
            orderResponseListDTO.setCount(count);
//            Color color = colorRepository.findById(f.)
            orderResponseListDTO.setColorname(f.getColor().getName());
            orderResponseListDTOS.add(orderResponseListDTO);
        }

        return ResponseEntity.ok(orderResponseListDTOS);
    }

    @Override
    public GetAccessTokenResponse completeOrder(String phone , CompeletOrderRequest request){
//        User user  = userRepository.findByMobile(phone);
//        if(user != null){
//            return ;
//        }
//       Optional<OrderList> orderList =  orderListRepository.findById(request.getOrderListId());
//        if(!orderList.isPresent() || !orderList.get().getUser().getId().equals(user.getId()))
//            return;
//        int counter = 0;
//        for (Address address : user.getAddresses())
//        {
//            if(address.getId() != request.getAddressId()) {
//                counter ++;
//                continue;
//            }
//            else
//                break;
//
//        }
//        if(user.getAddresses().size() == counter)
//            return;
//        Optional<Transport> transport = transportRepository.findById(request.getTransporstId());
//        if (!transport.isPresent())
//            return;
//
//        orderList.get().setAddressId(request.getAddressId());
//        orderList.get().setTransportId(transport.get().getId());
//orderListRepository.save(orderList.get());

        try {
            return   dargahConnection.getAccessToken(request.getOrderListId(),request.getTotalprice());
        } catch (IOException e) {
            e.printStackTrace();
        }
return null;
    }

    @Override
    public BaseResponseDTO editProductNumberInOrderList(String phone, EditProductNumberInOrderList request) {
        User user  = userRepository.findByMobile(phone);
        if( user == null){
            return null;
        }
//        Optional<OrderList> orderList = orderListRepository.findById(request.getOrderListId());
//        if (!orderList.isPresent())
//            return null;
//        Optional<ProductItem> productItem = productItemRepository.findById(request.getProductItemId());
//        if (!productItem.isPresent())
//            return null;
        OrderListProductItemNumber orderListProductItemNumber = orderListProductItemNumberRepository.findById(request.getOrderListId()).get();
        if (request.getNumber() <= 0){
            orderListProductItemNumberRepository.delete(orderListProductItemNumber);
        }
        else {
            orderListProductItemNumber.setNumber(request.getNumber());
            orderListProductItemNumberRepository.save(orderListProductItemNumber);
        }

        BaseResponseDTO baseResponseDTO =new BaseResponseDTO();
        baseResponseDTO.setMessage("با موفقیت ثبت شد");
        baseResponseDTO.setCode(200);
        return baseResponseDTO;
    }

    @Override
    public String  verifypayment(Long id, PaymentVerifyResquest paymentVerifyResquest) {
        try {
            return   dargahConnection.paymentVerify(id, paymentVerifyResquest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
