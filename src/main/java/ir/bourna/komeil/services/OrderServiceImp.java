package ir.bourna.komeil.services;

import ir.bourna.komeil.DTO.Response.BaseResponseDTO;
import ir.bourna.komeil.DTO.Response.ProductItemResponseDTO;
import ir.bourna.komeil.controllers.web.requests.CompeletOrderRequest;
import ir.bourna.komeil.controllers.web.requests.OrderSubmitRequest;
import ir.bourna.komeil.controllers.web.responses.OrderResponseListDTO;
import ir.bourna.komeil.models.*;
import ir.bourna.komeil.models.Enums.OrderListStatus;
import ir.bourna.komeil.models.intermediate.OrderListProductItemNumber;
import ir.bourna.komeil.repositories.*;
import org.hibernate.criterion.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderServiceImp implements OrderService {
    private final UserRepository userRepository;
    private final OrderListRepository orderListRepository;
    private final ProductItemRepository productItemRepository;
    private final OrderListProductItemNumberRepository orderListProductItemNumberRepository;
    private final TransportRepository transportRepository;
    private final ColorRepository colorRepository;

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
        Optional<Color> color = colorRepository.findById(request.getColorId());
//        if (!productItem.get().getColors().contains(color.get()))
//            return null;
        OrderList orderList = orderListRepository.findAllByOrderListStatusAndUser(OrderListStatus.NOT_PAID , user);
        if (orderList == null){
            orderList = new OrderList();
            orderList.setUser(user);
            orderList.setCreatedAt(System.currentTimeMillis() / 1000);
            orderList.setUpdatedAt(System.currentTimeMillis() / 1000);
            orderList.setOrderListStatus(OrderListStatus.NOT_PAID);
            orderList = orderListRepository.save(orderList);
        }

        Set<OrderListProductItemNumber> productItemNumberSet = orderList.getOrderListProductItemNumberSet();
        OrderListProductItemNumber orderListProductItemNumber = new OrderListProductItemNumber();
        orderListProductItemNumber.setProductItem(productItem.get());
        orderListProductItemNumber.setNumber(request.getNumber());
        orderListProductItemNumber.setorderList(orderList);
        productItemNumberSet.add(orderListProductItemNumber);
        orderListProductItemNumber.setColor(color.get());
        orderListProductItemNumberRepository.save(orderListProductItemNumber);
        orderList.setOrderListProductItemNumberSet(productItemNumberSet);
//        orderList.setOrderListStatus(OrderListStatus.NOT_PAID);
        orderListRepository.save(orderList);
        BaseResponseDTO baseResponseDTO =new BaseResponseDTO();
        baseResponseDTO.setMessage("با موفقیت ثبت شد");
        baseResponseDTO.setCode(200);
        return baseResponseDTO;
    }

    @Override
    public ResponseEntity<List<OrderResponseListDTO>> getOrderLog(OrderListStatus status, String phone){
        User user  = userRepository.findByMobile(phone);
        if(user == null){
            return null;
        }
      OrderList orderList =  orderListRepository.findAllByOrderListStatusAndUser(status,user);
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
    public void completeOrder(String phone , CompeletOrderRequest request){
        User user  = userRepository.findByMobile(phone);
        if(user != null){
            return ;
        }
       Optional<OrderList> orderList =  orderListRepository.findById(request.getOrderListId());
        if(!orderList.isPresent() || !orderList.get().getUser().getId().equals(user.getId()))
            return;
        int counter = 0;
        for (Address address : user.getAddresses())
        {
            if(address.getId() != request.getAddressId()) {
                counter ++;
                continue;
            }
            else
                break;

        }
        if(user.getAddresses().size() == counter)
            return;
        Optional<Transport> transport = transportRepository.findById(request.getTransporstId());
        if (!transport.isPresent())
            return;

        orderList.get().setAddressId(request.getAddressId());
        orderList.get().setTransportId(transport.get().getId());


    }
}
