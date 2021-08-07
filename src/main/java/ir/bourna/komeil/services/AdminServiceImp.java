package ir.bourna.komeil.services;

import com.google.common.collect.Lists;
import ir.bourna.komeil.DTO.Request.*;
import ir.bourna.komeil.DTO.Response.*;
import ir.bourna.komeil.config.HashConfig;
import ir.bourna.komeil.models.*;
import ir.bourna.komeil.models.Enums.OrderListStatus;
import ir.bourna.komeil.models.Enums.TicketStatus;
import ir.bourna.komeil.models.intermediate.OrderListProductItemNumber;
import ir.bourna.komeil.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@Service
public class AdminServiceImp implements AdminService {
    @Autowired
    ProductItemRepository productItemRepository;
    @Autowired
    ProductCategoryRepository productCategoryRepository;
    @Autowired
    BannerRepository bannerRepository;
    @Autowired
    BrandRepository brandRepository;
    @Autowired
    FilterRepository filterRepository;
    @Autowired
    BlogRepository blogRepository;
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    OrderListRepository orderListRepository;
    @Autowired
    AmazingOfferRepository amazingOfferRepository;
    @Autowired
    TransportRepository transportRepository;
    @Autowired
    ColorRepository colorRepository;
    @Autowired
    AdminsRepository adminsRepository;
    @Autowired
    RolesRepository rolesRepository;
    @Autowired
    HashConfig hashConfig;
    @Autowired
    ConfigRepository configRepository;
    @Autowired
    ProductAdditionalImageRepository productAdditionalImageRepository;
    @Autowired
    SubFilterRepository subFilterRepository;

    //--------PRODUCT CRUD----------
    @Override
    public BaseResponseDTO addProduct(AddProductRequestDTO addProductRequestDTO,String username) {
        Admins admins = adminsRepository.findByUsername(username);
        if(admins.getProduct_role()){
            Optional<Brand> brand = brandRepository.findById((long) addProductRequestDTO.getBrandId());
            Optional<ProductCategory> productCategory = productCategoryRepository.findById((long) addProductRequestDTO.getCategoryId());
            ProductItem productItem = new ProductItem();
            Set<Color> colors=new HashSet<>();
            for (int i = 0; i <addProductRequestDTO.getColorid().length ; i++) {
                Color color = colorRepository.findById(addProductRequestDTO.getColorid()[i]).get();
                colors.add(color);
            }
            productItem.setColors(colors);
            productItem.setName(addProductRequestDTO.getName());
            productItem.setDescription(addProductRequestDTO.getDescription());
            productItem.setImageUrl(addProductRequestDTO.getImageUrl());
            productItem.setNetPrice(addProductRequestDTO.getNetPrice());
            productItem.setDiscount(addProductRequestDTO.getDiscount());

            productItem.setCreatedAt(System.currentTimeMillis() / 1000);
            productItem.setUpdatedAt(System.currentTimeMillis() / 1000);
            productItem.setProductCategory(productCategory.get().getId());
            try {
                while (true){
                    String hash = hashConfig.CreateHash();
                    ProductItem productItem1 = productItemRepository.findByHashproduct(hash);
                    if(productItem1 == null){
                        productItem.setHashproduct(hash);
                        break;
                    }

                }



            } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            productItem.setBrandId(brand.get().getId());
            productItem.setEnable(true);
            productItem.setStock(addProductRequestDTO.getStock());
            productItemRepository.save(productItem);
            Set<ProductAdditionalImage>productAdditionalImages = new HashSet<>();
            for (String additionalImage : addProductRequestDTO.getAdditinoalimage()){
                ProductAdditionalImage productAdditionalImage = new ProductAdditionalImage();
                productAdditionalImage.setImageUrl(additionalImage);
                productAdditionalImage.setProductItem(productItem);
                productAdditionalImages.add(productAdditionalImage);
                productAdditionalImageRepository.save(productAdditionalImage);
            }
            productItem.setProductAdditionalImages(productAdditionalImages);
            productItemRepository.save(productItem);
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(200);
            baseResponseDTO.setMessage("محصول مورد نظر ثبت شد");
            return baseResponseDTO;
        }
        else{
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(403);
            baseResponseDTO.setMessage("اجازه ندارید");
            return baseResponseDTO;
        }


    }

    @Override
    public BaseResponseDTO editProduct(Long Id, AddProductRequestDTO addProductRequestDTO,String username) {
        Admins admins = adminsRepository.findByUsername(username);
        if(admins.getProduct_role()){
            Optional<Brand> brand = brandRepository.findById((long) addProductRequestDTO.getBrandId());
            Optional<ProductCategory> productCategory = productCategoryRepository.findById((long) addProductRequestDTO.getCategoryId());
            Optional<ProductItem> productItem = productItemRepository.findById(Id);
            if (productItem == null) {

                BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
                baseResponseDTO.setCode(400);
                baseResponseDTO.setMessage("محصول مورد نظر وجود ندارد");
                return baseResponseDTO;

            }
            productItem.get().setName(addProductRequestDTO.getName());
            productItem.get().setDescription(addProductRequestDTO.getDescription());
            productItem.get().setImageUrl(addProductRequestDTO.getImageUrl());
            productItem.get().setNetPrice(addProductRequestDTO.getNetPrice());
            productItem.get().setDiscount(addProductRequestDTO.getDiscount());
            productItem.get().setUpdatedAt(System.currentTimeMillis() / 1000);
            productItem.get().setStock(addProductRequestDTO.getStock());
            productItemRepository.save(productItem.get());

            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(200);
            baseResponseDTO.setMessage("محصول مورد نظر تغییر یافت");
            return baseResponseDTO;}
        else{
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(403);
            baseResponseDTO.setMessage("اجازه ندارید");
            return baseResponseDTO;
        }


    }

    @Override
    public ResponseEntity<List<ProductItemResponseDTO>> getProduct(String username) {
        Admins admins = adminsRepository.findByUsername(username);

            Iterable<ProductItem> productItems1 = productItemRepository.findAll();
            List<ProductItem> productItems =Lists.newArrayList(productItems1);
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
                productItemResponseDTO.setImageUrl(productItems.get(i).getImageUrl());
                productItemResponseDTO.setName(productItems.get(i).getName());
                Optional<ProductCategory> productCategory = productCategoryRepository.findById(productItems.get(i).getProductCategory());
                productItemResponseDTO.setCategoryname(productCategory.get().getName());
                Optional<Brand> brand = brandRepository.findById(productItems.get(i).getBrandId());
                productItemResponseDTO.setBrandname(brand.get().getTitle());
                productItemResponseDTO.setEnable(productItems.get(i).getEnable());
                productItemResponseDTOS.add(productItemResponseDTO);
            }
            return ResponseEntity.ok(productItemResponseDTOS);


    }

    @Override
    public ResponseEntity<List<Blog>> getBlog(String username) {
        Admins admins = adminsRepository.findByUsername(username);

            List<Blog> blogList = blogRepository.findAll();
            return ResponseEntity.ok(blogList);

    }

    @Override
    public ResponseEntity<List<Filter>> getFilter(String username) {
        Admins admins = adminsRepository.findByUsername(username);

            List<Filter> filterList = filterRepository.findAll();
            return ResponseEntity.ok(filterList);

    }

    @Override
    public ResponseEntity<List<BannerResponseDTO>> getBanner(String username) {
        Admins admins = adminsRepository.findByUsername(username);

            List<Banner> bannerList = bannerRepository.findAll();
            List<BannerResponseDTO> bannerResponseDTOS = new ArrayList<>();
            for(int i=0;i<bannerList.size();i++)
            {
                BannerResponseDTO bannerResponseDTO = new BannerResponseDTO();
                bannerResponseDTO.setId(bannerList.get(i).getId());
                bannerResponseDTO.setCategoryID(bannerList.get(i).getCategory().getId());
                bannerResponseDTO.setCategoryname(bannerList.get(i).getCategory().getName());
                bannerResponseDTO.setUrl(bannerList.get(i).getImageUrl());
                bannerResponseDTO.setBannertype(bannerList.get(i).getBannerType());
                bannerResponseDTOS.add(bannerResponseDTO);
            }
            return ResponseEntity.ok(bannerResponseDTOS);

    }

    @Override
    public ResponseEntity<List<ProductCategoryResponseDTO>> getCategory(String username) {
        Admins admins = adminsRepository.findByUsername(username);

            Iterable<ProductCategory> productItems1 = productCategoryRepository.findAll();
            List<ProductCategory> productCategories =Lists.newArrayList(productItems1);
            List<ProductCategoryResponseDTO> productCategoryList = new ArrayList<>();
            for(int i=0;i<productCategories.size();i++)
            {
                ProductCategoryResponseDTO productCategoryResponseDTOS = new ProductCategoryResponseDTO();
                productCategoryResponseDTOS.setId(productCategories.get(i).getId());
                productCategoryResponseDTOS.setName(productCategories.get(i).getName());
                productCategoryResponseDTOS.setEnable(productCategories.get(i).isEnable());

//            productCategoryResponseDTOS.setProductItemID(productItem.getId());
//            productCategoryResponseDTOS.setBannersID(productCategories.get(i).getBanners().toArray());
                productCategoryList.add(productCategoryResponseDTOS);
            }
            return ResponseEntity.ok(productCategoryList);

    }


    //--------CATEGORY CRUD----------
    @Override
    public BaseResponseDTO addCategory(AddCategoryRequestDTO addCategoryRequestDTO,String username) {
        Admins admins = adminsRepository.findByUsername(username);
        if(admins.getCategory_role()){
            ProductCategory productCategory = new ProductCategory();
            productCategory.setName(addCategoryRequestDTO.getName());
            productCategory.setEnable(true);
            productCategoryRepository.save(productCategory);
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(200);
            baseResponseDTO.setMessage("دسته بندی مورد نظر ثبت شد");
            return baseResponseDTO;
        }
        else{
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(403);
            baseResponseDTO.setMessage("اجازه ندارید");
            return baseResponseDTO;
        }

    }

    @Override
    public BaseResponseDTO editCategory(Long id, AddCategoryRequestDTO addCategoryRequestDTO,String username) {
        Admins admins = adminsRepository.findByUsername(username);
        if(admins.getCategory_role()){
            Optional<ProductCategory> productCategory = productCategoryRepository.findById(id);
            if (productCategory == null) {
                BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
                baseResponseDTO.setCode(400);
                baseResponseDTO.setMessage("دسته بندی مورد نظر وجود ندارد");
                return baseResponseDTO;

            }
            productCategory.get().setName(addCategoryRequestDTO.getName());
            productCategoryRepository.save(productCategory.get());
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(200);
            baseResponseDTO.setMessage("دسته بندی مورد نظر تغییر یافت");
            return baseResponseDTO;
        }

else{
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(403);
            baseResponseDTO.setMessage("اجازه ندارید");
            return baseResponseDTO;
        }
    }

    @Override
    public BaseResponseDTO changestateCategory(Long id,String username) {
        Admins admins = adminsRepository.findByUsername(username);
        if(admins.getCategory_role()){
            Optional<ProductCategory> productCategory = productCategoryRepository.findById(id);
            productCategory.get().setEnable(!productCategory.get().isEnable());
            productCategoryRepository.save(productCategory.get());
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(200);
            baseResponseDTO.setMessage("دسته بندی مورد نظر تغییر یافت");
            return baseResponseDTO;
        }
        else{
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(403);
            baseResponseDTO.setMessage("اجازه ندارید");
            return baseResponseDTO;
        }
    }


    //--------BANNER CRUD----------
    @Override
    public BaseResponseDTO addBanner(AddBannerRequestDTO addBannerRequestDTO,String username) {
        Admins admins = adminsRepository.findByUsername(username);
        if(admins.getBanner_role()){
            Banner banner = bannerRepository.findByBannerType(addBannerRequestDTO.getType());
            Optional<ProductCategory> productCategory = productCategoryRepository.findById(addBannerRequestDTO.getCategoryId());
            if(banner==null){
                Banner banner1 = new Banner();

                banner1.setImageUrl(addBannerRequestDTO.getUrl());
                banner1.setCreatedAt(System.currentTimeMillis()/1000);
                banner1.setUpdatedAt(System.currentTimeMillis()/1000);
                banner1.setCategory(productCategory.get());

                banner1.setBannerType(addBannerRequestDTO.getType());
                bannerRepository.save(banner1);
            }
            else{
                banner.setImageUrl(addBannerRequestDTO.getUrl());
                banner.setCategory(productCategory.get());

                banner.setUpdatedAt(System.currentTimeMillis()/1000);
                bannerRepository.save(banner);
            }

            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(200);
            baseResponseDTO.setMessage("بنر مورد نظر ثبت شد");
            return baseResponseDTO;
        }
        else{
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(403);
            baseResponseDTO.setMessage("اجازه ندارید");
            return baseResponseDTO;
        }

    }


    @Override
    public BaseResponseDTO editBanner(Long id, AddBannerRequestDTO addBannerRequestDTO,String username) {
        Admins admins = adminsRepository.findByUsername(username);
        if(admins.getBanner_role()){
            Optional<Banner> banner = bannerRepository.findById(id);
            Optional<ProductCategory> productCategory = productCategoryRepository.findById(addBannerRequestDTO.getCategoryId());
            if (productCategory == null) {
                BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
                baseResponseDTO.setCode(400);
                baseResponseDTO.setMessage("کتگوری مورد نظر وجود ندارد");
                return baseResponseDTO;

            }
            if (banner == null) {
                BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
                baseResponseDTO.setCode(400);
                baseResponseDTO.setMessage("بنر مورد نظر وجود ندارد");
                return baseResponseDTO;

            }

            banner.get().setImageUrl(addBannerRequestDTO.getUrl());
            banner.get().setCreatedAt(System.currentTimeMillis()/1000);
            banner.get().setUpdatedAt(System.currentTimeMillis()/1000);
            banner.get().setCategory(productCategory.get());

            bannerRepository.save(banner.get());
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(200);
            baseResponseDTO.setMessage("بنر مورد نظر تغییر یافت");
            return baseResponseDTO;
        }

   else{
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(403);
            baseResponseDTO.setMessage("اجازه ندارید");
            return baseResponseDTO;
        }
    }


    //--------Filter CRUD----------
    @Override
    public BaseResponseDTO addFilter(AddSearchFilterRequestDTO filterRequestDTO,String username) {
        Admins admins = adminsRepository.findByUsername(username);
        if(admins.getFilter_role()){
            Filter filter = new Filter();
            filter.setTitle(filterRequestDTO.getTitle());
            filterRepository.save(filter);
            filter.setFilter_id(filter.getId());
            filterRepository.save(filter);
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(200);
            baseResponseDTO.setMessage("فیلتر مورد نظر ثبت شد");
            return baseResponseDTO;
        }
        else{
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(403);
            baseResponseDTO.setMessage("اجازه ندارید");
            return baseResponseDTO;
        }

    }

    @Override
    public BaseResponseDTO addsubFilter(AddSubFilterRequestDTO addSubFilterRequestDTO,String username) {
        Admins admins = adminsRepository.findByUsername(username);
        if(admins.getFilter_role()){
            Optional<Filter> filter = filterRepository.findById(addSubFilterRequestDTO.getFilterId());
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            SubFilter subFilter = new SubFilter();
            if(!filter.isPresent())
            {
                baseResponseDTO.setCode(400);
                baseResponseDTO.setMessage("فیلتر مورد نظر وجود ندارد ");
                return baseResponseDTO;
            }
            for (Long number :addSubFilterRequestDTO.getSubFilters()) {
                Optional<Filter> filter1 = filterRepository.findById(number);
                if(!filter1.isPresent())
                {
                    baseResponseDTO.setCode(400);
                    baseResponseDTO.setMessage("ساب  فیلتر شماره " + number+
                            "نظر وجود نداردابتدا آن را ایجاد کنید");
                    return baseResponseDTO;
                }
                else {
                    SubFilter subFilter2 = new SubFilter();
                    subFilter2.setFilterId(filter.get().getId());
                    subFilter2.setSubName(filter1.get().getTitle());
                    subFilterRepository.save(subFilter2);
                }
            }
            baseResponseDTO.setCode(200);
            baseResponseDTO.setMessage("فیلتر مورد نظر ثبت شد");
            return baseResponseDTO;
        }
        else{
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(403);
            baseResponseDTO.setMessage("اجازه ندارید");
            return baseResponseDTO;
        }

    }

    //--------BLOG CRUD----------
    @Override
    public BaseResponseDTO CreateBlog(NewsRequestDTO newsRequestDTO,String username) {
        Admins admins = adminsRepository.findByUsername(username);
        if(admins.getNews_role()){
            Blog blog = new Blog();
            blog.setDescription(newsRequestDTO.getDescription());
            blog.setImageurl(newsRequestDTO.getImageurl());
            blog.setTopic(newsRequestDTO.getTopic());
            long currentTimestamp = System.currentTimeMillis();
            blog.setCreated_at(currentTimestamp);
            blog.setUpdated_at(currentTimestamp);
            blog.setEnable(true);
            blogRepository.save(blog);
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(200);
            baseResponseDTO.setMessage("خبر با موفقیت ثبت شد");
            return baseResponseDTO;
        }

          else{
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(403);
            baseResponseDTO.setMessage("اجازه ندارید");
            return baseResponseDTO;
        }
    }

    @Override
    public BaseResponseDTO editBlog(Long id, NewsRequestDTO newsRequestDTO,String username) {
        Admins admins = adminsRepository.findByUsername(username);
        if(admins.getNews_role()){
            Optional<Blog> blog = blogRepository.findById(id);
            if (blog.isPresent()) {
                blog.get().setDescription(newsRequestDTO.getDescription());
                blog.get().setImageurl(newsRequestDTO.getImageurl());
                blog.get().setTopic(newsRequestDTO.getTopic());
                long currentTimestamp = System.currentTimeMillis();
                blog.get().setUpdated_at(currentTimestamp);
                blogRepository.save(blog.get());
                BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
                baseResponseDTO.setCode(200);
                baseResponseDTO.setMessage("خبر با موفقیت تغییر یافت");
                return baseResponseDTO;

            } else {
                BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
                baseResponseDTO.setCode(400);
                baseResponseDTO.setMessage("خبر وجود  ندارد");
                return baseResponseDTO;
            }
        }
        else{
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(403);
            baseResponseDTO.setMessage("اجازه ندارید");
            return baseResponseDTO;
        }


    }

    @Override
    public BaseResponseDTO changestateblog(Long id,String username) {
        Admins admins = adminsRepository.findByUsername(username);
        if(admins.getNews_role()){
            Optional<Blog> blog = blogRepository.findById(id);
            blog.get().setEnable(!blog.get().isEnable());
            blogRepository.save(blog.get());
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(200);
            baseResponseDTO.setMessage("با موفقیت تغغیر کرد");
            return baseResponseDTO;
        }
        else{
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(403);
            baseResponseDTO.setMessage("اجازه ندارید");
            return baseResponseDTO;
        }

    }

    @Override
    public BaseResponseDTO Createbarnd(BrandRequestDTO brandRequestDTO,String username) {
        Admins admins = adminsRepository.findByUsername(username);
        if(admins.getBrand_role()){
            Brand brand = new Brand();
            brand.setEnable(true);
            brand.setTitle(brandRequestDTO.getTitle());
            brand.setDescription(brandRequestDTO.getDescription());
            brand.setImageUrl(brandRequestDTO.getImageurl());
            brandRepository.save(brand);
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(200);
            baseResponseDTO.setMessage("با موفقیت ایجاد شد");
            return baseResponseDTO;
        }

         else{
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(403);
            baseResponseDTO.setMessage("اجازه ندارید");
            return baseResponseDTO;
        }
    }

    @Override
    public BaseResponseDTO editbrand(Long id, BrandRequestDTO BrandRequestDTO,String username) {
        Admins admins = adminsRepository.findByUsername(username);
        if(admins.getBrand_role()){
            Optional<Brand> Brand = brandRepository.findById(id);
            if (Brand.isPresent()) {
                Brand.get().setDescription(BrandRequestDTO.getDescription());
                Brand.get().setImageUrl(BrandRequestDTO.getImageurl());
                Brand.get().setTitle(BrandRequestDTO.getTitle());
                brandRepository.save(Brand.get());
                BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
                baseResponseDTO.setCode(200);
                baseResponseDTO.setMessage("برند با موفقیت تغییر یافت");
                return baseResponseDTO;

            } else {
                BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
                baseResponseDTO.setCode(400);
                baseResponseDTO.setMessage("برند وجود ندارد");
                return baseResponseDTO;
            }
        }

 else{
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(403);
            baseResponseDTO.setMessage("اجازه ندارید");
            return baseResponseDTO;
        }
    }

    @Override
    public ResponseEntity<List<BrandResponseDTO>> getbarnd(String username) {
        Admins admins = adminsRepository.findByUsername(username);

            List<Brand> brands = brandRepository.findAll();
            List<BrandResponseDTO> brandResponseDTOS = new ArrayList<>();
            for(int i=0;i<brands.size();i++)
            {
                BrandResponseDTO brandResponseDTO = new BrandResponseDTO();
                brandResponseDTO.setId(brands.get(i).getId());
                brandResponseDTO.setDescription(brands.get(i).getDescription());
                brandResponseDTO.setImageUrl(brands.get(i).getImageUrl());
                brandResponseDTO.setTitle(brands.get(i).getTitle());
                brandResponseDTO.setEnable(brands.get(i).isEnable());
                brandResponseDTOS.add(brandResponseDTO);
            }
            return ResponseEntity.ok(brandResponseDTOS);

    }

    @Override
    public BaseResponseDTO changestatebrand(Long id,String username) {
        Admins admins = adminsRepository.findByUsername(username);
        if(admins.getBrand_role()){
            Optional<Brand> brand = brandRepository.findById(id);
            brand.get().setEnable(!brand.get().isEnable());
            brandRepository.save(brand.get());
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(200);
            baseResponseDTO.setMessage("با موفقیت تغغیر کرد");
            return baseResponseDTO;
        }
         else{
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(403);
            baseResponseDTO.setMessage("اجازه ندارید");
            return baseResponseDTO;
        }
    }

    @Override
    public BaseResponseDTO ResponseTicket(TicketRequestDTO ticketRequestDTO,String username) {
        Admins admins = adminsRepository.findByUsername(username);
        if(admins.getTicket_role()){
            User user = userRepository.findByMobile(ticketRequestDTO.getMobile());


            Ticket ticket1 = new Ticket();
            ticket1.setContent(ticketRequestDTO.getContent());
            ticket1.setCreatedAt(System.currentTimeMillis() / 1000);
            ticket1.setUpdatedAt(System.currentTimeMillis() / 1000);
            ticket1.setTicketStatus(TicketStatus.Answer);
            ticket1.setUser(user);

            ticketRepository.save(ticket1);

            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(200);
            baseResponseDTO.setMessage("تیکت پاسخ داده شد");
            return baseResponseDTO;

        }


   else{
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(403);
            baseResponseDTO.setMessage("اجازه ندارید");
            return baseResponseDTO;
        }
    }

    @Override
    public ResponseEntity<List<TicketOutSql>> GetAllTicket(String username) {
        Admins admins = adminsRepository.findByUsername(username);
        if(admins.getTicket_role()){
            List<TicketOutSql> tickets = ticketRepository.listofTicket();
            return ResponseEntity.ok(tickets);
        }
        else
            return  ResponseEntity.ok(new ArrayList<>());

    }

    @Override
    public ResponseEntity<List<OrderListResponseDTO>> GetAllPayedOrders(String username) {
        Admins admins = adminsRepository.findByUsername(username);
        if(admins.getTransport_role()){
            List<OrderList> orders = orderListRepository.findAllByOrderListStatus(OrderListStatus.PAID);
            List<OrderListResponseDTO> orderLists = new ArrayList<>();
            HashMap<String,String> productItems = new HashMap<>();
            List<HashMap<String,String>> hashMaps = new ArrayList<>();
            for(int i=0;i<orders.size();i++)
            {
                OrderListResponseDTO orderListResponseDTO = new OrderListResponseDTO();
                orderListResponseDTO.setId(orders.get(i).getId());
                System.out.println(orders.get(i).getId());
                orderListResponseDTO.setDescription(orders.get(i).getDescription());
                System.out.println(orders.get(i).getDescription());
                orderListResponseDTO.setSetAddress(orders.get(i).getUser().getAddresses());
                orderListResponseDTO.setOrderListStatus(orders.get(i).getOrderListStatus());
                for (OrderListProductItemNumber orderListProductItemNumber :orders.get(i).getOrderListProductItemNumberSet()) {
                    productItems = new HashMap<>();
                    productItems.put("ProductItemNumber", String.valueOf(orderListProductItemNumber.getNumber()));
                    System.out.println(String.valueOf(orderListProductItemNumber.getNumber()));
                    productItems.put("ProductName",orderListProductItemNumber.getProductItem().getName());
                    System.out.println(orderListProductItemNumber.getProductItem().getName());
                    productItems.put("ProductDescription",orderListProductItemNumber.getProductItem().getDescription());
                    productItems.put("ProductImageUrl",orderListProductItemNumber.getProductItem().getImageUrl());
                    hashMaps.add(productItems);
                }
                orderListResponseDTO.setProductItems(hashMaps);
                orderLists.add(orderListResponseDTO);
            }
            return ResponseEntity.ok(orderLists);
        }
     else
         return ResponseEntity.ok(new ArrayList<>());
    }


    //--------AMAZING OFFER CRUD----------

    @Override
    public BaseResponseDTO editAmazingOffer(int id, AddAmazingOfferRequestDTO addAmazingOfferRequestDTO,String username) {
        Admins admins = adminsRepository.findByUsername(username);
        if(admins.getProduct_role()){
            Optional<AmazingOffer> amazingOffer = amazingOfferRepository.findById((long) id);
            if (amazingOffer == null) {
                BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
                baseResponseDTO.setCode(400);
                baseResponseDTO.setMessage("محصول فوق العاده مورد نظر وجود ندارد");
                return baseResponseDTO;

            }
            Optional<ProductItem> productItem = productItemRepository.findById(addAmazingOfferRequestDTO.getProductItem());
            if (productItem == null) {
                BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
                baseResponseDTO.setCode(400);
                baseResponseDTO.setMessage("محصول مورد نظر وجود ندارد");
                return baseResponseDTO;

            }
            amazingOffer.get().setProductItem(productItem.get().getId());
            amazingOffer.get().setStartDate(addAmazingOfferRequestDTO.getStartDate());
            amazingOffer.get().setEndDate(addAmazingOfferRequestDTO.getEndDate());
            amazingOffer.get().setUpdatedAt(System.currentTimeMillis() / 1000);
            amazingOfferRepository.save(amazingOffer.get());

            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(200);
            baseResponseDTO.setMessage("محصول فوق العاده مورد نظر تغییر یافت");
            return baseResponseDTO;
        }

   else{
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(403);
            baseResponseDTO.setMessage("اجازه ندارید");
            return baseResponseDTO;
        }
    }

    @Override
    public List<AmazingOfferResponseDTO> getAmazingOffer(String username) {
        Admins admins = adminsRepository.findByUsername(username);

            List<AmazingOfferResponseDTO> amazingOfferResponseDTOS = new ArrayList<>();
            Iterable<AmazingOffer> iterable  =  amazingOfferRepository.findAll();

            List<AmazingOffer> amazingOffers = Lists.newArrayList(iterable);
            for(int i=0;i<amazingOffers.size();i++)
            {
                AmazingOfferResponseDTO amazingOfferResponseDTO = new AmazingOfferResponseDTO();
                Optional<ProductItem> productItem = productItemRepository.findById(amazingOffers.get(i).getProductItem());
                amazingOfferResponseDTO.setId(amazingOffers.get(i).getId());
                amazingOfferResponseDTO.setEndDate(amazingOffers.get(i).getEndDate());
                amazingOfferResponseDTO.setStartDate(amazingOffers.get(i).getStartDate());
                amazingOfferResponseDTO.setProductItemId(productItem.get().getId());
                amazingOfferResponseDTO.setProductname(productItem.get().getName());
                amazingOfferResponseDTOS.add(amazingOfferResponseDTO);
            }
            return amazingOfferResponseDTOS;

    }

    @Override
    public BaseResponseDTO addAmazingOffer(AddAmazingOfferRequestDTO addAmazingOfferRequestDTO,String username) {
        Admins admins = adminsRepository.findByUsername(username);
        if(admins.getProduct_role()){
            AmazingOffer amazingOffer = new AmazingOffer();
            Optional<ProductItem> productItem = productItemRepository.findById(addAmazingOfferRequestDTO.getProductItem());
            amazingOffer.setProductItem(productItem.get().getId());
            amazingOffer.setCreatedAt(System.currentTimeMillis() / 1000);
            amazingOffer.setUpdatedAt(System.currentTimeMillis() / 1000);
            amazingOffer.setStartDate(addAmazingOfferRequestDTO.getStartDate());
            amazingOffer.setEndDate(addAmazingOfferRequestDTO.getEndDate());
            amazingOfferRepository.save(amazingOffer);
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(200);
            baseResponseDTO.setMessage("محصول فوق العاده مورد نظر ثبت شد");
            return baseResponseDTO;
        }

   else{
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(403);
            baseResponseDTO.setMessage("اجازه ندارید");
            return baseResponseDTO;
        }
    }

    //--------TRANSPORT CRUD----------
    @Override
    public ResponseEntity<List<Transport>> getTransport(String username) {
        Admins admins = adminsRepository.findByUsername(username);

            List<Transport> transports = transportRepository.findAll();
            return ResponseEntity.ok(transports);

    }

    @Override
    public BaseResponseDTO addTransport(TransportRequestDTO transportRequestDTO,String username) {
        Admins admins = adminsRepository.findByUsername(username);
        if(admins.getTransport_role()){
            Transport transport = new Transport();
            transport.setTransport(transportRequestDTO.getTransportName());
            transport.setCreated_at(System.currentTimeMillis() / 1000);
            transport.setUpdated_at((long) 0);
            transport.setEnable(true);
            transportRepository.save(transport);
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(200);
            baseResponseDTO.setMessage("روش ارسال مورد نظر ثبت شد");
            return baseResponseDTO;
        }

   else{
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(403);
            baseResponseDTO.setMessage("اجازه ندارید");
            return baseResponseDTO;
        }
    }

    @Override
    public BaseResponseDTO editTransport(int id, TransportRequestDTO transportRequestDTO,String username) {
        Admins admins = adminsRepository.findByUsername(username);
        if(admins.getTransport_role()){
            Optional<Transport> transport = transportRepository.findById((long) id);
            if (transport == null) {
                BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
                baseResponseDTO.setCode(400);
                baseResponseDTO.setMessage("روش ارسال مورد نظر وجود ندارد");
                return baseResponseDTO;

            }
            transport.get().setTransport(transportRequestDTO.getTransportName());
            transport.get().setUpdated_at(System.currentTimeMillis() / 1000);
            transportRepository.save(transport.get());
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(200);
            baseResponseDTO.setMessage("روش ارسال مورد نظر تغییر یافت");
            return baseResponseDTO;
        }

   else{
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(403);
            baseResponseDTO.setMessage("اجازه ندارید");
            return baseResponseDTO;
        }
    }

    @Override
    public BaseResponseDTO changestatetransport(long id,String username) {
        Admins admins = adminsRepository.findByUsername(username);
        if(admins.getTransport_role()){
            Optional<Transport> transport = transportRepository.findById(id);
            transport.get().setEnable(!transport.get().isEnable());
            transportRepository.save(transport.get());
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(200);
            baseResponseDTO.setMessage(" تغییر یافت");
            return baseResponseDTO;
        }

           else{
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(403);
            baseResponseDTO.setMessage("اجازه ندارید");
            return baseResponseDTO;
        }
    }

    @Override
    public BaseResponseDTO Createcolor(ColorRequestDTO colorRequestDTO,String username) {
        Admins admins = adminsRepository.findByUsername(username);
        if(admins.getColor_role()){
            Color color = new Color();
            color.setHex(colorRequestDTO.getHex());
            color.setEnable(true);
            color.setName(colorRequestDTO.getName());
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(200);
            baseResponseDTO.setMessage("با موفقیت ثبت شد");
            colorRepository.save(color);
            return baseResponseDTO;
        }

           else{
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(403);
            baseResponseDTO.setMessage("اجازه ندارید");
            return baseResponseDTO;
        }
    }

    @Override
    public BaseResponseDTO editcolor(Long id, ColorRequestDTO colorRequestDTO,String username) {
        Admins admins = adminsRepository.findByUsername(username);
        if(admins.getColor_role()){
            Optional<Color> color = colorRepository.findById(id);
            color.get().setHex(colorRequestDTO.getHex());
            color.get().setName(colorRequestDTO.getName());
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(200);
            baseResponseDTO.setMessage("با موفقیت تغییر کرد");
            colorRepository.save(color.get());
            return baseResponseDTO;
        }

           else{
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(403);
            baseResponseDTO.setMessage("اجازه ندارید");
            return baseResponseDTO;
        }
    }

    @Override
    public ResponseEntity<List<Color>> getcolor(String username) {
        Admins admins = adminsRepository.findByUsername(username);

            List<Color> colors = colorRepository.findAll();
            return ResponseEntity.ok(colors);

    }

    @Override
    public BaseResponseDTO changestatecolor(Long id,String username) {
        Admins admins = adminsRepository.findByUsername(username);
        if(admins.getColor_role()){
            Optional<Color> color = colorRepository.findById(id);
            color.get().setEnable(!color.get().isEnable());
            colorRepository.save(color.get());
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(200);
            baseResponseDTO.setMessage("با موفقیت تغغیر کرد");
            return baseResponseDTO;
        }

           else{
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(403);
            baseResponseDTO.setMessage("اجازه ندارید");
            return baseResponseDTO;
        }
    }


    @Override
    public ResponseEntity<List<Admins>> getAssignedRole(String username) {
        Admins admin = adminsRepository.findByUsername(username);

            List<Admins> admins = adminsRepository.findAll();
            return ResponseEntity.ok(admins);


    }

    @Override
    public BaseResponseDTO editAssignedRole(int id, AssignRolesRolesRequestDTO assignRolesRolesRequestDTO,String username) {
        Admins admins = adminsRepository.findByUsername(username);
        if(admins.getAdmin_role()){
            Admins admin = adminsRepository.findByUsername(assignRolesRolesRequestDTO.getUsername());
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            Set<Roles> rolesSet = new HashSet<>();
            if (admin == null) {
                baseResponseDTO.setCode(400);
                baseResponseDTO.setMessage("ادمین وجود ندارد");
                return baseResponseDTO;
            }
            admin.setUsername(assignRolesRolesRequestDTO.getUsername());
            admin.setPassword(assignRolesRolesRequestDTO.getPassword());
            admin.setUpdatedAt(System.currentTimeMillis() / 1000);
            admin.setAdmin_role(assignRolesRolesRequestDTO.getAdmin_role());
            admin.setBanner_role(assignRolesRolesRequestDTO.getBanner_role());
            admin.setBrand_role(assignRolesRolesRequestDTO.getBrand_role());
            admin.setCategory_role(assignRolesRolesRequestDTO.getCategory_role());
            admin.setColor_role(assignRolesRolesRequestDTO.getColor_role());
            admin.setNews_role(assignRolesRolesRequestDTO.getNews_role());
            admin.setStatic_role(assignRolesRolesRequestDTO.getStatic_role());
            admin.setFilter_role(assignRolesRolesRequestDTO.getFilter_role());
            admin.setTicket_role(assignRolesRolesRequestDTO.getTicket_role());
            admin.setTransport_role(assignRolesRolesRequestDTO.getTransport_role());
            admin.setProduct_role(assignRolesRolesRequestDTO.getProduct_role());
            adminsRepository.save(admin);
            baseResponseDTO.setCode(200);
            baseResponseDTO.setMessage("نقش مورد نظر با موفقیت تغییر کرد");
            return baseResponseDTO;
        }
        else{
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(403);
            baseResponseDTO.setMessage("اجازه ندارید");
            return baseResponseDTO;
        }
    }

    @Override
    public BaseResponseDTO assignRoles(AssignRolesRolesRequestDTO assignRolesRolesRequestDTO,String username) {
        Admins admins = adminsRepository.findByUsername(username);
        if(admins.getAdmin_role()){
            Admins admin = new Admins();
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            admin.setCreatedAt(System.currentTimeMillis() / 1000);
            admin.setUsername(assignRolesRolesRequestDTO.getUsername());
            admin.setPassword(assignRolesRolesRequestDTO.getPassword());
            admin.setUpdatedAt(System.currentTimeMillis() / 1000);
            admin.setAdmin_role(assignRolesRolesRequestDTO.getAdmin_role());
            admin.setBanner_role(assignRolesRolesRequestDTO.getBanner_role());
            admin.setBrand_role(assignRolesRolesRequestDTO.getBrand_role());
            admin.setCategory_role(assignRolesRolesRequestDTO.getCategory_role());
            admin.setColor_role(assignRolesRolesRequestDTO.getColor_role());
            admin.setNews_role(assignRolesRolesRequestDTO.getNews_role());
            admin.setStatic_role(assignRolesRolesRequestDTO.getStatic_role());
            admin.setFilter_role(assignRolesRolesRequestDTO.getFilter_role());
            admin.setTicket_role(assignRolesRolesRequestDTO.getTicket_role());
            admin.setTransport_role(assignRolesRolesRequestDTO.getTransport_role());
            admin.setProduct_role(assignRolesRolesRequestDTO.getProduct_role());
            adminsRepository.save(admin);
            baseResponseDTO.setCode(200);
            baseResponseDTO.setMessage("نقش مورد نظر با موفقیت داده شد");
            return baseResponseDTO;
        }


           else{
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(403);
            baseResponseDTO.setMessage("اجازه ندارید");
            return baseResponseDTO;
        }
    }

    @Override
    public ResponseEntity<List<Roles>> getRoles(String username) {
        Admins admins = adminsRepository.findByUsername(username);
        if(admins.getAdmin_role()){
            List<Roles> rolesList = rolesRepository.findAll();
            return ResponseEntity.ok(rolesList);
        }
        else
            return ResponseEntity.ok(new ArrayList<>());

    }

    @Override
    public BaseResponseDTO editRoles(int id, AddRolesRequestDTO addRolesRequestDTO,String username) {
        Admins admins = adminsRepository.findByUsername(username);
        if(admins.getAdmin_role()){
            Optional<Roles> roles = rolesRepository.findById((long) id);
            if (roles == null) {
                BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
                baseResponseDTO.setCode(400);
                baseResponseDTO.setMessage("نفش مورد نظر وجود ندارد");
                return baseResponseDTO;



            }
            roles.get().setRole(addRolesRequestDTO.getRoleName());
            roles.get().setUpdatedAt(System.currentTimeMillis() / 1000);
            rolesRepository.save(roles.get());
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(200);
            baseResponseDTO.setMessage("نفش مورد نظر تغییر یافت");
            return baseResponseDTO;
        }


           else{
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(403);
            baseResponseDTO.setMessage("اجازه ندارید");
            return baseResponseDTO;
        }
    }

    @Override
    public BaseResponseDTO changeStateRole(Long id,String username) {
        Admins admins = adminsRepository.findByUsername(username);
        if(admins.getAdmin_role()){
            Optional<Roles> roles = rolesRepository.findById(id);
            roles.get().setEnable(!roles.get().getEnable());
            rolesRepository.save(roles.get());
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(200);
            baseResponseDTO.setMessage("با موفقیت تغغیر کرد");
            return baseResponseDTO;
        }

           else{
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(403);
            baseResponseDTO.setMessage("اجازه ندارید");
            return baseResponseDTO;
        }
    }

    @Override
    public BaseResponseDTO changeAssignedRole(Long id,String username) {
        Admins admin = adminsRepository.findByUsername(username);
        if(admin.getAdmin_role()){
            Optional<Admins> admins = adminsRepository.findById(id);
            admins.get().setEnable(!admins.get().getEnable());
            adminsRepository.save(admins.get());
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(200);
            baseResponseDTO.setMessage("با موفقیت تغغیر کرد");
            return baseResponseDTO;
        }

           else{
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(403);
            baseResponseDTO.setMessage("اجازه ندارید");
            return baseResponseDTO;
        }
    }

    @Override
    public BaseResponseDTO loginAdmin(AdminLoginRequestDTO adminLoginRequestDTO) {

        Admins admins = adminsRepository.findByUsername(adminLoginRequestDTO.getUsername());
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        if(admins ==null)
        {
            baseResponseDTO.setCode(400);
            baseResponseDTO.setMessage("این ادمین وجود  ندارد");
            return baseResponseDTO;
        }else
        {
            if(!admins.getPassword().equals(adminLoginRequestDTO.getPassword()))
            {
                baseResponseDTO.setCode(400);
                baseResponseDTO.setMessage("پسورد غلط است");
                return baseResponseDTO;
            }else
            {
                baseResponseDTO.setCode(200);
                baseResponseDTO.setMessage("ورود موفقیت آمیز است");
                return baseResponseDTO;
            }
        }
    }

    @Override
    public BaseResponseDTO changestateproduct(Long id,String username) {
        Admins admins = adminsRepository.findByUsername(username);
        if(admins.getProduct_role()){
            Optional<ProductItem> productItem = productItemRepository.findById(id);
            productItem.get().setEnable(!productItem.get().getEnable());
            productItemRepository.save(productItem.get());
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(200);
            baseResponseDTO.setMessage("با موفقیت تغغیر کرد");
            return baseResponseDTO;
        }


           else{
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(403);
            baseResponseDTO.setMessage("اجازه ندارید");
            return baseResponseDTO;
        }
    }

    @Override
    public ResponseEntity<List<Ticket>> GetAlluserTicket(String mobile,String username) {

        Admins admins = adminsRepository.findByUsername(username);
        if(admins.getTicket_role()){
            User user = userRepository.findByMobile(mobile);
            List<Ticket> ticketList = ticketRepository.findAllByUser(user);
            return  ResponseEntity.ok(ticketList);
        }
        else return ResponseEntity.ok(new ArrayList<>());

    }



    @Override
    public BaseResponseDTO postconfig(ConfigRequestDTO configRequestDTO, String username) {
        Admins admins = adminsRepository.findByUsername(username);
        if(admins.getAdmin_role()){
            Config config =configRepository.findById(new Long(1)).get();

            config.setAboutUsPartOne(configRequestDTO.getPartoneaboutus());
            config.setAboutUsPartTwo(configRequestDTO.getParttwoaboutus());
            configRepository.save(config);   BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(200);
            baseResponseDTO.setMessage("با موفقیت ثبت شد");
            return baseResponseDTO;

        }
        else{
            BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
            baseResponseDTO.setCode(403);
            baseResponseDTO.setMessage("اجازه ندارید");
            return baseResponseDTO;
        }
    }

    @Override
    public ResponseEntity<List<Config>> getconfig(String username) {
        Admins admins = adminsRepository.findByUsername(username);
        if(admins.getAdmin_role()){
            List<Config> config = configRepository.findAll();
            return ResponseEntity.ok(config);
        }
        else
            return ResponseEntity.ok(new ArrayList<>());
    }
}
