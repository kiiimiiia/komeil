package ir.bourna.komeil.services;

import ir.bourna.komeil.DTO.Response.BaseResponseDTO;
import ir.bourna.komeil.DTO.Response.BrandResponseDTO;
import ir.bourna.komeil.DTO.Response.ProductItemResponseDTO;
import ir.bourna.komeil.controllers.web.responses.BannerResponseDTO;
import ir.bourna.komeil.controllers.web.responses.SearchDropDownResponse;
import ir.bourna.komeil.models.*;
import ir.bourna.komeil.utils.BaseResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LandingService {

    List<Filter> getAllFilters();
    List<ProductCategory> getAllCategories();
    List<BannerResponseDTO> getAllBanners();
    List<Blog> getAllBlogs();
    List<BrandResponseDTO> getAllBrands();
    List<ProductItemResponseDTO> getAmazingOffers(int startPage , int pageSize);
    List<ProductItemResponseDTO> getProductItems(int startPage , int pageSize);

    ResponseEntity<ProductItemResponseDTO> getDetailProductItems(String hash);

    ResponseEntity<List<ProductItemResponseDTO>> listproductwithcategory(String id);

    ResponseEntity<List<ProductItemResponseDTO>> getbrandproduct(String id);

    ResponseEntity<Brand> getbranddetail(String id);

    ResponseEntity<List<SearchDropDownResponse>> getSearchDropDown(String keyword);
    ResponseEntity<Config> getConfig();
    ResponseEntity<List<ProductItemResponseDTO>> getSearchEnter(String keyword , int page , int size);

    ResponseEntity<List<ProductItemResponseDTO>> relatedproduct(String hash);

    ResponseEntity<Blog> getdetailBlogs(String id);
    List<ProductItemResponseDTO> getfirstpageproduct();

    ResponseEntity<BaseResponse> getOtp(String phone);

    ResponseEntity<ProductCategory> getdetailcategory(String id);
}
