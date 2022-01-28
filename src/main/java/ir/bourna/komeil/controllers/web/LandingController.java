package ir.bourna.komeil.controllers.web;

import ir.bourna.komeil.DTO.Response.BaseResponseDTO;
import ir.bourna.komeil.DTO.Response.BrandResponseDTO;
import ir.bourna.komeil.DTO.Response.ProductItemResponseDTO;
import ir.bourna.komeil.controllers.web.responses.BannerResponseDTO;
import ir.bourna.komeil.controllers.web.responses.SearchDropDownResponse;
import ir.bourna.komeil.models.*;
import ir.bourna.komeil.services.LandingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/web/v1/landing")
public class LandingController {
    final LandingService landingService;
    @Autowired
    public LandingController(
            LandingService landingService
    ){
        this.landingService = landingService;
    }

    @RequestMapping(value = "/filters" ,  method = RequestMethod.GET)
    public List<Filter> getFilters(){
        return landingService.getAllFilters();
    }

    @RequestMapping(value = "/categories" ,  method = RequestMethod.GET)
    public List<ProductCategory> getCategories(){
        return landingService.getAllCategories();
    }

    @RequestMapping(value = "/banners" ,  method = RequestMethod.GET)
    public List<BannerResponseDTO> getBanners(){
        return landingService.getAllBanners();
    }

    @RequestMapping(value = "/blogs" ,  method = RequestMethod.GET)
    public List<Blog> getBlogs(){
        return landingService.getAllBlogs();
    }

    @RequestMapping(value = "/detailblogs" ,  method = RequestMethod.GET)
    public ResponseEntity<Blog> getdetailBlog(@RequestParam("id") String id){
        return landingService.getdetailBlogs(id);
    }
    @RequestMapping(value = "/brands" ,  method = RequestMethod.GET)
    public  List<BrandResponseDTO> getbrands(){
        return landingService.getAllBrands();
    }

    @RequestMapping(value = "/amazing-offers" , method = RequestMethod.GET)
    public List<ProductItemResponseDTO> getAmazingOffer(@RequestParam("page") int page, @RequestParam("size") int size){
        return landingService.getAmazingOffers(page , size);
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<ProductItemResponseDTO> getProducts(@RequestParam("page") int page, @RequestParam("size") int size){
        return landingService.getProductItems(page , size);
    }
    @RequestMapping(value = "/detailproducts", method = RequestMethod.GET)
    public ResponseEntity<ProductItemResponseDTO> detailproducts(@RequestParam("hash") String hash){
        return landingService.getDetailProductItems(hash);
    }
    @RequestMapping(value = "/related", method = RequestMethod.GET)
    public ResponseEntity<List<ProductItemResponseDTO>> relatedproducts(@RequestParam("hash") String hash){
        return landingService.relatedproduct(hash);
    }
    @RequestMapping(value = "/listproductwithcategory", method = RequestMethod.GET)
    public ResponseEntity<List<ProductItemResponseDTO>> listproductwithcategory(@RequestParam("categoryid") String id){
        return landingService.listproductwithcategory(id);
    }
    @RequestMapping(value = "/getbrandproduct", method = RequestMethod.GET)
    public ResponseEntity<List<ProductItemResponseDTO>> getbrandproduct(@RequestParam("brandid") String id){
        return landingService.getbrandproduct(id);
    }
    @RequestMapping(value = "/getbranddetail", method = RequestMethod.GET)
    public ResponseEntity<Brand> getbranddetail(@RequestParam("brandid") String id){
        return landingService.getbranddetail(id);
    }
    @RequestMapping(value = "/search-drop-down/{keyword}", method = RequestMethod.GET)
    public ResponseEntity<List<SearchDropDownResponse>> getSearchDropDown(@PathVariable("keyword") String keyword){
        return landingService.getSearchDropDown(keyword);
    }

    @RequestMapping(value = "/search-enter/{keyword}", method = RequestMethod.GET)
    public ResponseEntity<List<ProductItemResponseDTO>> getSearchEnter(@PathVariable("keyword") String keyword ,@RequestParam("page") int page, @RequestParam("size") int size){
        return landingService.getSearchEnter(keyword , page , size);
    }
    @GetMapping("/firstpageproduct")
    private List<ProductItemResponseDTO> getfirstpageproduct() {
        return landingService.getfirstpageproduct();
    }
    @RequestMapping(value = "/config", method = RequestMethod.GET)
    public ResponseEntity<Config> getConfig(){
        return landingService.getConfig();
    }

}
