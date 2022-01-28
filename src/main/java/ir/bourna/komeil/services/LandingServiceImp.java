package ir.bourna.komeil.services;

import com.google.common.collect.Lists;
import ir.bourna.komeil.DTO.Response.BaseResponseDTO;
import ir.bourna.komeil.DTO.Response.BrandResponseDTO;
import ir.bourna.komeil.DTO.Response.ProductItemResponseDTO;
import ir.bourna.komeil.controllers.web.responses.BannerResponseDTO;
import ir.bourna.komeil.controllers.web.responses.SearchDropDownResponse;
import ir.bourna.komeil.models.*;
import ir.bourna.komeil.models.intermediate.ProductitemColor;
import ir.bourna.komeil.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LandingServiceImp implements LandingService{
    private final FilterRepository filterRepository;
    private final ProductCategoryRepository productCategoryRepository;
    private final BannerRepository bannerRepository;
    private final BlogRepository blogRepository;
    private final BrandRepository brandRepository;
    private final AmazingOfferRepository amazingOfferRepository;
    private final ProductItemRepository productItemRepository;
    private final ConfigRepository configRepository;
    private  final ColorRepository colorRepository;
    private final FirstpageProductRepository firstpageProductRepository;
    @Autowired
    public LandingServiceImp(
            FilterRepository filterRepository,
            ProductCategoryRepository productCategoryRepository,
            BannerRepository bannerRepository,
            BlogRepository blogRepository,
            BrandRepository brandRepository,
            AmazingOfferRepository amazingOfferRepository,
            ProductItemRepository productItemRepository,
            ColorRepository colorRepository,
            FirstpageProductRepository firstpageProductRepository,
            ConfigRepository configRepository
    ){
        this.filterRepository = filterRepository;
        this.productCategoryRepository = productCategoryRepository;
        this.bannerRepository = bannerRepository;
        this.blogRepository = blogRepository;
        this.brandRepository = brandRepository;
        this.amazingOfferRepository = amazingOfferRepository;
        this.productItemRepository = productItemRepository;
        this.colorRepository=colorRepository;
        this.configRepository = configRepository;
        this.firstpageProductRepository=firstpageProductRepository;
    }


    public List<Filter> getAllFilters(){
        return filterRepository.findAll();
    }
    public List<ProductCategory> getAllCategories(){
        return productCategoryRepository.findAllByEnable(true);
    }

    public List<BannerResponseDTO> getAllBanners(){
        List<Banner> bannerList =bannerRepository.findAll();
        List<BannerResponseDTO>bannerResponseDTOS=new ArrayList<>();
        for (int i = 0; i <bannerList.size() ; i++) {
            BannerResponseDTO bannerResponseDTO=new BannerResponseDTO();
            bannerResponseDTO.setBannerType(bannerList.get(i).getBannerType());
            bannerResponseDTO.setImageUrl(bannerList.get(i).getImageUrl());
            bannerResponseDTO.setCategoryName(bannerList.get(i).getCategory().getName());
            bannerResponseDTO.setCategoryId(bannerList.get(i).getCategory().getId());
            bannerResponseDTOS.add(bannerResponseDTO);
        }
        return bannerResponseDTOS;
    }

    public List<Blog> getAllBlogs(){
        return blogRepository.findAll();
    }

    public  List<BrandResponseDTO> getAllBrands()
    {
        List<Brand> brands = brandRepository.findAllByVip(true);
        List<BrandResponseDTO> brandResponseDTOS = new ArrayList<>();
        for(int i=0;i<brands.size();i++)
        {
            if(brands.get(i).isEnable()){
                BrandResponseDTO brandResponseDTO = new BrandResponseDTO();
                brandResponseDTO.setId(brands.get(i).getId());
                brandResponseDTO.setDescription(brands.get(i).getDescription());
                brandResponseDTO.setImageUrl(brands.get(i).getImageUrl());
                brandResponseDTO.setTitle(brands.get(i).getTitle());
                brandResponseDTO.setVip(brands.get(i).isVip());
                brandResponseDTOS.add(brandResponseDTO);
            }

        }
        return brandResponseDTOS;


    }

    public List<ProductItemResponseDTO> getAmazingOffers(int pageNo , int pageSize){

        Pageable pageRange = PageRequest.of(pageNo, pageSize);
        Page<AmazingOffer> pagedResult = amazingOfferRepository.findAll(pageRange);
        List<AmazingOffer> productItems = pagedResult.toList();
        List<ProductItemResponseDTO> productItemResponseDTOS = new ArrayList<>();
        for(int i=0;i<productItems.size();i++)
        {
            Optional<ProductItem> productItem = productItemRepository.findById(productItems.get(i).getProductItem());
            if(productItem.get().getEnable()){

                if(productItems.get(i).getEndDate()>=System.currentTimeMillis()/1000){
                    ProductItemResponseDTO productItemResponseDTO = new ProductItemResponseDTO();
                    productItemResponseDTO.setId(productItem.get().getId());
                    productItemResponseDTO.setDescription(productItem.get().getDescription());
                    productItemResponseDTO.setDiscount(productItem.get().getDiscount());
                    productItemResponseDTO.setNetPrice(productItem.get().getNetPrice());
                    productItemResponseDTO.setRate(productItem.get().getRate());
                    productItemResponseDTO.setStock(productItem.get().getStock());
                    productItemResponseDTO.setImageUrl(productItem.get().getImageUrl());
                    productItemResponseDTO.setName(productItem.get().getName());
                    productItemResponseDTO.setHash(productItem.get().getHashproduct());
                    Optional<ProductCategory> productCategory = productCategoryRepository.findById(productItem.get().getProductCategory());
                    productItemResponseDTO.setCategoryname(productCategory.get().getName());
                    Optional<Brand> brand = brandRepository.findById(productItem.get().getBrandId());
                    productItemResponseDTO.setBrandname(brand.get().getTitle());
                    productItemResponseDTO.setEnable(productItem.get().getEnable());
                    productItemResponseDTO.setHave(productItem.get().getHave());
                    productItemResponseDTOS.add(productItemResponseDTO);
                }

            }

        }
        return productItemResponseDTOS;


    }

    public List<ProductItemResponseDTO> getProductItems(int pageNo , int pageSize){
        Pageable pageRange = PageRequest.of(pageNo, pageSize);
        Page<ProductItem> pagedResult = productItemRepository.findAllByEnable(pageRange , true);
        List<ProductItem> productItems = pagedResult.toList();
        List<ProductItemResponseDTO> productItemResponseDTOS = new ArrayList<>();
        for(int i=0;i<productItems.size();i++)
        {

                ProductItemResponseDTO productItemResponseDTO = new ProductItemResponseDTO();
                productItemResponseDTO.setId(productItems.get(i).getId());
                productItemResponseDTO.setDescription(productItems.get(i).getDescription());
                productItemResponseDTO.setDiscount(productItems.get(i).getDiscount());
                productItemResponseDTO.setNetPrice(productItems.get(i).getNetPrice());
                productItemResponseDTO.setRate(productItems.get(i).getRate());
                productItemResponseDTO.setStock(productItems.get(i).getStock());
            productItemResponseDTO.setHash(productItems.get(i).getHashproduct());
                productItemResponseDTO.setImageUrl(productItems.get(i).getImageUrl());
                productItemResponseDTO.setName(productItems.get(i).getName());
                Optional<ProductCategory> productCategory = productCategoryRepository.findById(productItems.get(i).getProductCategory());
                productItemResponseDTO.setCategoryname(productCategory.get().getName());
                Optional<Brand> brand = brandRepository.findById(productItems.get(i).getBrandId());
                productItemResponseDTO.setBrandname(brand.get().getTitle());
                productItemResponseDTO.setEnable(productItems.get(i).getEnable());
                productItemResponseDTO.setHave(productItems.get(i).getHave());

                productItemResponseDTOS.add(productItemResponseDTO);


        }
        return productItemResponseDTOS;
    }

    @Override
    public ResponseEntity<ProductItemResponseDTO> getDetailProductItems(String hash) {
        ProductItem productItems = productItemRepository.findByHashproduct(hash);
        ProductItemResponseDTO productItemResponseDTO = new ProductItemResponseDTO();
        if(productItems.getEnable()){
            productItemResponseDTO.setId(productItems.getId());
            productItemResponseDTO.setDescription(productItems.getDescription());
            productItemResponseDTO.setDiscount(productItems.getDiscount());
            productItemResponseDTO.setNetPrice(productItems.getNetPrice());
            productItemResponseDTO.setRate(productItems.getRate());
            productItemResponseDTO.setStock(productItems.getStock());
            productItemResponseDTO.setHash(productItems.getHashproduct());
            productItemResponseDTO.setImageUrl(productItems.getImageUrl());
            productItemResponseDTO.setName(productItems.getName());
            productItemResponseDTO.setProductWidth(productItems.getProductWidth());
            productItemResponseDTO.setProductLength(productItems.getProductLength());
            productItemResponseDTO.setProductHeight(productItems.getProductHeight());
            productItemResponseDTO.setBoxWidth(productItems.getBoxWidth());
            productItemResponseDTO.setBoxLength(productItems.getBoxLength());
            productItemResponseDTO.setMaterial(productItems.getMaterial());
            productItemResponseDTO.setCount(productItems.getCount());
            productItemResponseDTO.setWeight(productItems.getWeight());
            productItemResponseDTO.setBoxHeight(productItems.getBoxHeight());
            Set<ProductitemColor> colors= productItems.getProductitemColors();
            List<Color> listcolor=new ArrayList<>();
            for (Iterator<ProductitemColor> it = colors.iterator(); it.hasNext(); ) {
                ProductitemColor f = it.next();
if(f.getEnable()){
    listcolor.add(f.getColor());

}


            }
productItemResponseDTO.setColorsList(listcolor);
            productItemResponseDTO.setProductAdditionalImages(productItems.getProductAdditionalImages());
            Optional<ProductCategory> productCategory = productCategoryRepository.findById(productItems.getProductCategory());
            productItemResponseDTO.setCategoryname(productCategory.get().getName());
            Optional<Brand> brand = brandRepository.findById(productItems.getBrandId());
            productItemResponseDTO.setBrandname(brand.get().getTitle());
            productItemResponseDTO.setEnable(productItems.getEnable());
productItemResponseDTO.setHave(productItems.getHave());
        }
        return  ResponseEntity.ok(productItemResponseDTO);
    }

    @Override
    public ResponseEntity<List<ProductItemResponseDTO>> listproductwithcategory(String id) {

        List<ProductItem> productItems = productItemRepository.findByProductCategory(Long.parseLong(id));
        List<ProductItemResponseDTO> productItemResponseDTOS = new ArrayList<>();
        for(int i=0;i<productItems.size();i++)
        {
            if(productItems.get(i).getEnable()){
                ProductItemResponseDTO productItemResponseDTO = new ProductItemResponseDTO();
                productItemResponseDTO.setId(productItems.get(i).getId());
                productItemResponseDTO.setDescription(productItems.get(i).getDescription());
                productItemResponseDTO.setDiscount(productItems.get(i).getDiscount());
                productItemResponseDTO.setNetPrice(productItems.get(i).getNetPrice());
                productItemResponseDTO.setRate(productItems.get(i).getRate());
                productItemResponseDTO.setStock(productItems.get(i).getStock());
                productItemResponseDTO.setHash(productItems.get(i).getHashproduct());
                productItemResponseDTO.setImageUrl(productItems.get(i).getImageUrl());
                productItemResponseDTO.setName(productItems.get(i).getName());
                Optional<ProductCategory> productCategory = productCategoryRepository.findById(productItems.get(i).getProductCategory());
                productItemResponseDTO.setCategoryname(productCategory.get().getName());
                Optional<Brand> brand = brandRepository.findById(productItems.get(i).getBrandId());
                productItemResponseDTO.setBrandname(brand.get().getTitle());
                productItemResponseDTO.setEnable(productItems.get(i).getEnable());
                productItemResponseDTO.setHave(productItems.get(i).getHave());
                productItemResponseDTOS.add(productItemResponseDTO);
            }

        }
        return ResponseEntity.ok(productItemResponseDTOS);
    }

    @Override
    public ResponseEntity<List<ProductItemResponseDTO>> getbrandproduct(String id) {
        List<ProductItem> productItems = productItemRepository.findAllByBrandId(Long.parseLong(id));
        List<ProductItemResponseDTO> productItemResponseDTOS = new ArrayList<>();
        for(int i=0;i<productItems.size();i++)
        {
            if(productItems.get(i).getEnable()){
                ProductItemResponseDTO productItemResponseDTO = new ProductItemResponseDTO();
                productItemResponseDTO.setId(productItems.get(i).getId());
                productItemResponseDTO.setDescription(productItems.get(i).getDescription());
                productItemResponseDTO.setDiscount(productItems.get(i).getDiscount());
                productItemResponseDTO.setNetPrice(productItems.get(i).getNetPrice());
                productItemResponseDTO.setRate(productItems.get(i).getRate());
                productItemResponseDTO.setStock(productItems.get(i).getStock());
                productItemResponseDTO.setHash(productItems.get(i).getHashproduct());
                productItemResponseDTO.setImageUrl(productItems.get(i).getImageUrl());
                productItemResponseDTO.setName(productItems.get(i).getName());
                Optional<ProductCategory> productCategory = productCategoryRepository.findById(productItems.get(i).getProductCategory());
                productItemResponseDTO.setCategoryname(productCategory.get().getName());
                Optional<Brand> brand = brandRepository.findById(productItems.get(i).getBrandId());
                productItemResponseDTO.setBrandname(brand.get().getTitle());
                productItemResponseDTO.setEnable(productItems.get(i).getEnable());
                productItemResponseDTOS.add(productItemResponseDTO);
            }

        }
        return ResponseEntity.ok(productItemResponseDTOS);
    }

    @Override
    public ResponseEntity<Brand> getbranddetail(String id) {
        Brand brand = brandRepository.findById(Long.parseLong(id)).get();
        return ResponseEntity.ok(brand);
    }

    @Override
    public ResponseEntity<List<SearchDropDownResponse>> getSearchDropDown(String keyword){
        Pageable pageRange = PageRequest.of(0, 10);
        List<ProductItem> productItems = productItemRepository.findByNameContainsAndEnable(pageRange , keyword , true).toList();
        List<SearchDropDownResponse> result = new ArrayList<>();
        for (ProductItem productItem : productItems){
            ProductCategory productCategory = productCategoryRepository.findById(productItem.getProductCategory()).get();
            SearchDropDownResponse searchDropDownResponse = new SearchDropDownResponse(productItem.getName(),productItem.getHashproduct(),productCategory.getName());
            result.add(searchDropDownResponse);
        }
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<Config> getConfig(){
        return ResponseEntity.ok(configRepository.findAll().get(0));
    }

    @Override
    public ResponseEntity<List<ProductItemResponseDTO>> getSearchEnter(String keyword , int page , int size){
        Pageable pageRange = PageRequest.of(page, size);
        List<ProductItem> productItems = productItemRepository.findByNameContainsAndEnable(pageRange , keyword , true).toList();
        List<ProductItemResponseDTO> productItemResponseDTOS = new ArrayList<>();
        for(int i=0;i<productItems.size();i++)
        {
                ProductItemResponseDTO productItemResponseDTO = new ProductItemResponseDTO();
                productItemResponseDTO.setId(productItems.get(i).getId());
                productItemResponseDTO.setDescription(productItems.get(i).getDescription());
                productItemResponseDTO.setDiscount(productItems.get(i).getDiscount());
                productItemResponseDTO.setNetPrice(productItems.get(i).getNetPrice());
                productItemResponseDTO.setRate(productItems.get(i).getRate());
                productItemResponseDTO.setStock(productItems.get(i).getStock());
                productItemResponseDTO.setHash(productItems.get(i).getHashproduct());
                productItemResponseDTO.setImageUrl(productItems.get(i).getImageUrl());
                productItemResponseDTO.setName(productItems.get(i).getName());
                Optional<ProductCategory> productCategory = productCategoryRepository.findById(productItems.get(i).getProductCategory());
                productItemResponseDTO.setCategoryname(productCategory.get().getName());
                Optional<Brand> brand = brandRepository.findById(productItems.get(i).getBrandId());
                productItemResponseDTO.setBrandname(brand.get().getTitle());
                productItemResponseDTO.setEnable(productItems.get(i).getEnable());
                productItemResponseDTO.setHave(productItems.get(i).getHave());
                productItemResponseDTOS.add(productItemResponseDTO);

        }
        return ResponseEntity.ok(productItemResponseDTOS);
    }

    @Override
    public ResponseEntity<List<ProductItemResponseDTO>> relatedproduct(String hash) {
        ProductItem productItem = productItemRepository.findByHashproduct(hash);
        List<ProductItem> productItems = productItemRepository.relatedList(productItem.getProductCategory(),hash);
        List<ProductItemResponseDTO>productItemResponseDTOS = new ArrayList<>();
        for (int i = 0; i <productItems.size() ; i++) {
            if(productItems.get(i).getEnable()){
                ProductItemResponseDTO productItemResponseDTO = new ProductItemResponseDTO();
                productItemResponseDTO.setId(productItems.get(i).getId());
                productItemResponseDTO.setDescription(productItems.get(i).getDescription());
                productItemResponseDTO.setDiscount(productItems.get(i).getDiscount());
                productItemResponseDTO.setNetPrice(productItems.get(i).getNetPrice());
                productItemResponseDTO.setRate(productItems.get(i).getRate());
                productItemResponseDTO.setStock(productItems.get(i).getStock());
                productItemResponseDTO.setHash(productItems.get(i).getHashproduct());
                productItemResponseDTO.setImageUrl(productItems.get(i).getImageUrl());
                productItemResponseDTO.setName(productItems.get(i).getName());
                Optional<ProductCategory> productCategory = productCategoryRepository.findById(productItems.get(i).getProductCategory());
                productItemResponseDTO.setCategoryname(productCategory.get().getName());
                Optional<Brand> brand = brandRepository.findById(productItems.get(i).getBrandId());
                productItemResponseDTO.setBrandname(brand.get().getTitle());
                productItemResponseDTO.setEnable(productItems.get(i).getEnable());
                productItemResponseDTOS.add(productItemResponseDTO);
            }

        }
        return ResponseEntity.ok(productItemResponseDTOS);
    }

    @Override
    public ResponseEntity<Blog> getdetailBlogs(String id) {
        Blog blog = blogRepository.findById(Long.parseLong(id)).get();
        return ResponseEntity.ok(blog);
    }
    @Override
    public List<ProductItemResponseDTO> getfirstpageproduct() {
        Iterable<FirstpageProduct> firstpageProducts = firstpageProductRepository.findAll();
        List<FirstpageProduct> firstpageProduct =Lists.newArrayList(firstpageProducts);
        List<ProductItemResponseDTO> productItemResponseDTOS = new ArrayList<>();
        for(int i=0;i<firstpageProduct.size();i++)
        {
            ProductItem productItems= productItemRepository.findById(Long.parseLong(firstpageProduct.get(i).getProductId())).get();
            ProductItemResponseDTO productItemResponseDTO = new ProductItemResponseDTO();
            productItemResponseDTO.setId(productItems.getId());
            productItemResponseDTO.setDescription(productItems.getDescription());
            productItemResponseDTO.setDiscount(productItems.getDiscount());
            productItemResponseDTO.setNetPrice(productItems.getNetPrice());
            productItemResponseDTO.setRate(productItems.getRate());
            productItemResponseDTO.setStock(productItems.getStock());
            productItemResponseDTO.setImageUrl(productItems.getImageUrl());
            productItemResponseDTO.setName(productItems.getName());
            productItemResponseDTO.setHash(productItems.getHashproduct());
            productItemResponseDTO.setProductHeight(productItems.getProductHeight());
            productItemResponseDTO.setProductLength(productItems.getProductLength());
            productItemResponseDTO.setProductWidth(productItems.getProductWidth());
            productItemResponseDTO.setBoxHeight(productItems.getBoxHeight());
            productItemResponseDTO.setBoxLength(productItems.getBoxLength());
            productItemResponseDTO.setWeight(productItems.getWeight());
            productItemResponseDTO.setCount(productItems.getCount());
            productItemResponseDTO.setMaterial(productItems.getMaterial());
            productItemResponseDTO.setHave(productItems.getHave());
            productItemResponseDTO.setBoxWidth(productItems.getBoxWidth());
//                System.out.println(productItems.get(i).getProductCategory());
            Optional<ProductCategory> productCategory = productCategoryRepository.findById(productItems.getProductCategory());
            productItemResponseDTO.setCategoryname(productCategory.get().getName());
            Optional<Brand> brand = brandRepository.findById(productItems.getBrandId());
            productItemResponseDTO.setBrandname(brand.get().getTitle());
            productItemResponseDTO.setEnable(productItems.getEnable());
            productItemResponseDTOS.add(productItemResponseDTO);
        }
        return productItemResponseDTOS;
    }

}
