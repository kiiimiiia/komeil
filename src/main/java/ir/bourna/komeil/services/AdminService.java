package ir.bourna.komeil.services;

import ir.bourna.komeil.DTO.Request.*;
import ir.bourna.komeil.DTO.Response.*;
import ir.bourna.komeil.models.*;
import ir.bourna.komeil.models.intermediate.ProductitemColor;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdminService {
    ProductItem addProduct(AddProductRequestDTO addProductRequestDTO,String username);

    BaseResponseDTO editProduct(Long Id, AddProductRequestDTO addProductRequestDTO,String username);

    BaseResponseDTO addCategory(AddCategoryRequestDTO addCategoryRequestDTO,String username);

    BaseResponseDTO editCategory(Long id, AddCategoryRequestDTO addCategoryRequestDTO,String username);

    BaseResponseDTO editBanner(Long id, AddBannerRequestDTO addBannerRequestDTO,String username);

    BaseResponseDTO addBanner(AddBannerRequestDTO addBannerRequestDTO,String username);

 

    BaseResponseDTO addFilter(AddSearchFilterRequestDTO filterRequestDTO,String username);

    BaseResponseDTO addsubFilter(AddSubFilterRequestDTO addSubFilterRequestDTO,String username);

    BaseResponseDTO CreateBlog(NewsRequestDTO newsRequestDTO,String username);

    BaseResponseDTO editBlog(Long id, NewsRequestDTO newsRequestDTO,String username);

    BaseResponseDTO ResponseTicket(TicketRequestDTO ticketRequestDTO,String username);

    ResponseEntity<List<TicketOutSql>> GetAllTicket(String username);

    ResponseEntity<List<OrderListResponseDTO>> GetAllPayedOrders(String username);

    ResponseEntity<List<ProductItemResponseDTO>> getProduct(String username);

    ResponseEntity<List<Blog>> getBlog(String username);

    ResponseEntity<List<Filter>> getFilter(String username);

    ResponseEntity<List<BannerResponseDTO>> getBanner(String username);

    ResponseEntity<List<ProductCategoryResponseDTO>> getCategory(String username);

    BaseResponseDTO editAmazingOffer(int id, AddAmazingOfferRequestDTO addAmazingOfferRequestDTO,String username);

    List<AmazingOfferResponseDTO> getAmazingOffer(String username);

    BaseResponseDTO addAmazingOffer(AddAmazingOfferRequestDTO addAmazingOfferRequestDTO,String username);

    ResponseEntity<List<Transport>> getTransport(String username);

    BaseResponseDTO addTransport(TransportRequestDTO transportRequestDTO,String username);

    BaseResponseDTO editTransport(int id, TransportRequestDTO transportRequestDTO,String username);

    BaseResponseDTO changestateblog(Long id,String username);

    BaseResponseDTO Createbarnd(BrandRequestDTO brandRequestDTO,String username);

    BaseResponseDTO editbrand(Long id, BrandRequestDTO BrandRequestDTO,String username);

    ResponseEntity<List<BrandResponseDTO>> getbarnd(String username);

    BaseResponseDTO changestatebrand(Long id,String username);

    BaseResponseDTO Createcolor(ColorRequestDTO colorRequestDTO,String username);

    BaseResponseDTO editcolor(Long id, ColorRequestDTO colorRequestDTO,String username);

    ResponseEntity<List<Color>> getcolor(String username);

    BaseResponseDTO changestatecolor(Long id,String username);

    BaseResponseDTO changestateCategory(Long id,String username);

    ResponseEntity<List<Admins>> getAssignedRole(String username);

    BaseResponseDTO editAssignedRole(int id, AssignRolesRolesRequestDTO assignRolesRolesRequestDTO,String username);

    BaseResponseDTO assignRoles(AssignRolesRolesRequestDTO assignRolesRolesRequestDTO,String username);

    ResponseEntity<List<Roles>> getRoles(String username);

    BaseResponseDTO editRoles(int id, AddRolesRequestDTO addRolesRequestDTO,String username);

    BaseResponseDTO changeStateRole(Long id,String username);

    BaseResponseDTO changeAssignedRole(Long id,String username);

    BaseResponseDTO loginAdmin(AdminLoginRequestDTO adminLoginRequestDTO);

    BaseResponseDTO changestatetransport(long id,String username);

    BaseResponseDTO changestateproduct(Long id,String username);

    ResponseEntity<List<Ticket>> GetAlluserTicket(String mobile,String username);

    BaseResponseDTO postconfig(ConfigRequestDTO configRequestDTO, String username);

    ResponseEntity<List<Config>> getconfig(String username);

    BaseResponseDTO endofstock(Long id, String username);

    BaseResponseDTO postproductitemcolor(ProductitemColorRequestDTO productitemColorRequestDTO, String username);

    BaseResponseDTO putproductitemcolor(ProductitemColorRequestDTO productitemColorRequestDTO, String username, Long id);

    BaseResponseDTO changestateProductitemcolor(Long id, String username);

    List<ProductitemColor> getProductitemcolor(String username);

    BaseResponseDTO postdiscount(DiscountRequestDTO discountRequestDTO, String username);

    BaseResponseDTO putdiscount(DiscountRequestDTO discountRequestDTO, String username, Long id);

    BaseResponseDTO changestatediscount(Long id, String username);

    List<Discount> getdiscount(String username);

    ResponseEntity<GeneratehashcodeResponse> generateHashCode();
    BaseResponseDTO Createfirstpageproduct(AddFirstpageProductDTO addFirstpageProductDTO, String username);

    BaseResponseDTO deletefirstpageproduct(Long id, String username);

    ResponseEntity<List<ProductItemResponseDTO>> getfirstpageproduct(String username);
}
