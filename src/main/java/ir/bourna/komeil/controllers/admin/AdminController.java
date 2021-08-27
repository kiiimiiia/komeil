package ir.bourna.komeil.controllers.admin;

import io.swagger.annotations.ApiOperation;
import ir.bourna.komeil.DTO.Request.*;
import ir.bourna.komeil.DTO.Response.*;
import ir.bourna.komeil.models.*;
import ir.bourna.komeil.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping("/login")
    private BaseResponseDTO loginAdmin(@RequestBody AdminLoginRequestDTO adminLoginRequestDTO) {
        return adminService.loginAdmin(adminLoginRequestDTO);
    }

    //--------PRODUCT CRUD----------

    @PostMapping("/product")
    private BaseResponseDTO addProduct(@RequestBody AddProductRequestDTO addProductRequestDTO,@RequestParam String username) {
        return adminService.addProduct(addProductRequestDTO,username);
    }

    @PutMapping("/product")
    private BaseResponseDTO editProduct(@RequestParam Long Id, @RequestBody AddProductRequestDTO addProductRequestDTO,@RequestParam String username) {
        return adminService.editProduct(Id, addProductRequestDTO,username);
    }

    @GetMapping("/product")
    private ResponseEntity<List<ProductItemResponseDTO>> getProduct(@RequestParam String username) {
        return adminService.getProduct(username);
    }

    @PutMapping("/changestateproduct")
    private BaseResponseDTO changestateproduct(@RequestParam Long id,@RequestParam String username) {
        return adminService.changestateproduct(id,username);
    }

    @PutMapping("/endofstock")
    private BaseResponseDTO endofstock(@RequestParam Long id,@RequestParam String username) {
        return adminService.endofstock(id,username);
    }
    //--------CATEGORY CRUD----------

    @PostMapping("/category")
    private BaseResponseDTO addCategory(@RequestBody AddCategoryRequestDTO addCategoryRequestDTO,@RequestParam String username) {
        return adminService.addCategory(addCategoryRequestDTO,username);
    }

    @PutMapping("/category")
    private BaseResponseDTO editCategory(@RequestParam Long id, @RequestBody AddCategoryRequestDTO addCategoryRequestDTO,@RequestParam String username) {
        return adminService.editCategory(id, addCategoryRequestDTO,username);
    }
    @GetMapping("/category")
    private ResponseEntity<List<ProductCategoryResponseDTO>> getCategory(@RequestParam String username) {
        return adminService.getCategory(username);
    }
    @PutMapping("/changestatecategory")
    private BaseResponseDTO editCategory(@RequestParam Long id,@RequestParam String username) {
        return adminService.changestateCategory(id,username);
    }
    //--------BANNER CRUD----------

    @PostMapping("/banner")
    private BaseResponseDTO addBanner(@RequestBody AddBannerRequestDTO addBannerRequestDTO,@RequestParam String username) {
        return adminService.addBanner(addBannerRequestDTO,username);
    }

    @PutMapping("/banner")
    private BaseResponseDTO editBanner(@RequestParam Long Id, @RequestBody AddBannerRequestDTO addBannerRequestDTO,@RequestParam String username) {
        return adminService.editBanner(Id, addBannerRequestDTO,username);
    }
    @GetMapping("/banner")
    private ResponseEntity<List<BannerResponseDTO>> getBanner(@RequestParam String username) {
        return adminService.getBanner(username);
    }

    //--------FILTER CRUD----------
    @PostMapping("/filter")
    private BaseResponseDTO addFilter(@RequestBody AddSearchFilterRequestDTO addSearchFilterRequestDTO,@RequestParam String username) {
        return adminService.addFilter(addSearchFilterRequestDTO,username);
    }
    @PostMapping("/subfilter")
    private BaseResponseDTO addsubFilter(@RequestBody AddSubFilterRequestDTO addSubFilterRequestDTO,@RequestParam String username) {
        return adminService.addsubFilter(addSubFilterRequestDTO,username);
    }
    @GetMapping("/filter")
    private ResponseEntity<List<Filter>> getFilter(@RequestParam String username) {
        return adminService.getFilter(username);
    }
    //--------BLOG CRUD----------

    @RequestMapping(value = "/blog" ,  method = RequestMethod.POST)
    @ApiOperation("Api for Create News ")
    public BaseResponseDTO CreateBlog(@RequestBody NewsRequestDTO newsRequestDTO,@RequestParam String username) {
        return adminService.CreateBlog(newsRequestDTO,username);
    }
    @PutMapping("/blog")
    @ApiOperation("Api for edit News ")
    private BaseResponseDTO editBlog(@RequestParam Long id,@RequestBody NewsRequestDTO newsRequestDTO,@RequestParam String username)
    {
        return adminService.editBlog(id,newsRequestDTO,username);
    }
    @GetMapping("/blog")
    private ResponseEntity<List<Blog>> getBlog(@RequestParam String username) {
        return adminService.getBlog(username);
    }
    @PutMapping("/changestateblog")
    private BaseResponseDTO changestateblog(@RequestParam Long id,@RequestParam String username)
    {
        return adminService.changestateblog(id,username);
    }
    //--------TICKET CRUD----------
    @PostMapping("/ticket")
    @ApiOperation("Api for Response to a ticket of a user  ")
    public BaseResponseDTO ResponseTicket(@RequestBody TicketRequestDTO ticketRequestDTO,@RequestParam String username) {
        return adminService.ResponseTicket(ticketRequestDTO,username);
    }
    @GetMapping("/ticket")
    @ApiOperation("Api for getting all recorded tickets ")
    public ResponseEntity<List<TicketOutSql>> GetAllTicket(@RequestParam String username) {
        return adminService.GetAllTicket(username);
    }
    @GetMapping("/detailticket")
    @ApiOperation("Api for getting all recorded tickets ")
    public ResponseEntity<List<Ticket>> GetAllTusericket(@RequestParam String mobile,@RequestParam String username) {
        return adminService.GetAlluserTicket(mobile,username);
    }
    //--------ORDER LIST CRUD----------
    @GetMapping("/orders")
    @ApiOperation("Api for getting all payed orders ")
    public ResponseEntity<List<OrderListResponseDTO>> GetAllPayedOrders(@RequestParam String username) {

        return adminService.GetAllPayedOrders(username);
    }

    //--------TRANSPORT CRUD----------

    @PostMapping("/transport")
    private BaseResponseDTO addTransport(@RequestBody TransportRequestDTO transportRequestDTO,@RequestParam String username) {
        return adminService.addTransport(transportRequestDTO,username);
    }

    @PutMapping("/transport")
    private BaseResponseDTO editTransport(@RequestParam int Id, @RequestBody TransportRequestDTO transportRequestDTO,@RequestParam String username) {
        return adminService.editTransport(Id, transportRequestDTO,username);
    }
    @PutMapping("/changestatetransport")
    private BaseResponseDTO changestatetransport(@RequestParam long Id,@RequestParam String username) {
        return adminService.changestatetransport(Id,username);
    }
    @GetMapping("/transport")
    private ResponseEntity<List<Transport>> getTransport(@RequestParam String username) {

        return adminService.getTransport(username);
    }

    //--------AMAZING OFFER  CRUD----------
    @PostMapping("/amzoffer")
    private BaseResponseDTO addAmazingOffer(@RequestBody AddAmazingOfferRequestDTO addAmazingOfferRequestDTO,@RequestParam String username) {
        return adminService.addAmazingOffer(addAmazingOfferRequestDTO,username);
    }

    @PutMapping("/amzoffer")
    private BaseResponseDTO editAmazingOffer(@RequestParam int Id, @RequestBody AddAmazingOfferRequestDTO addAmazingOfferRequestDTO,@RequestParam String username) {
        return adminService.editAmazingOffer(Id, addAmazingOfferRequestDTO,username);
    }

    @GetMapping("/amzoffer")
    private List<AmazingOfferResponseDTO> getAmazingOffer(@RequestParam String username) {
        return adminService.getAmazingOffer(username);
    }

    //--------Brand CRUD----------

    @RequestMapping(value = "/brand" ,  method = RequestMethod.POST)
    @ApiOperation("Api for Create brand ")
    public BaseResponseDTO CreateBrand(@RequestBody  BrandRequestDTO brandRequestDTO,@RequestParam String username) {
        return adminService.Createbarnd(brandRequestDTO,username);
    }
    @PutMapping("/brand")
    @ApiOperation("Api for edit brand ")
    private BaseResponseDTO editbrand(@RequestParam Long id,@RequestBody BrandRequestDTO BrandRequestDTO,@RequestParam String username)
    {
        return adminService.editbrand(id,BrandRequestDTO,username);
    }
    @GetMapping("/brand")
    private ResponseEntity<List<BrandResponseDTO>> getbrand(@RequestParam String username) {
        return adminService.getbarnd(username);
    }
    @PutMapping("/changestatebrand")
    private BaseResponseDTO changestatebrand(@RequestParam Long id,@RequestParam String username)
    {
        return adminService.changestatebrand(id,username);
    }

    //--------color CRUD----------

    @RequestMapping(value = "/color" ,  method = RequestMethod.POST)
    @ApiOperation("Api for Create color ")
    public BaseResponseDTO Createcolor(@RequestBody  ColorRequestDTO ColorRequestDTO,@RequestParam String username) {
        return adminService.Createcolor(ColorRequestDTO,username);
    }
    @PutMapping("/color")
    @ApiOperation("Api for edit brand ")
    private BaseResponseDTO editcolor(@RequestParam Long id,@RequestBody ColorRequestDTO ColorRequestDTO,@RequestParam String username)
    {
        return adminService.editcolor(id,ColorRequestDTO,username);
    }
    @GetMapping("/color")
    private ResponseEntity<List<Color>> getcolor(@RequestParam String username) {
        return adminService.getcolor(username);
    }
    @PutMapping("/changestatecolor")
    private BaseResponseDTO changestatecolor(@RequestParam Long id,@RequestParam String username)
    {
        return adminService.changestatecolor(id,username);
    }

    //--------ROLE CRUD----------

    @PutMapping("/roles")
    @ApiOperation("Api for edit a role ")
    private BaseResponseDTO editRoles(@RequestParam int Id, @RequestBody AddRolesRequestDTO addRolesRequestDTO,@RequestParam String username) {
        return adminService.editRoles(Id, addRolesRequestDTO,username);
    }

    @GetMapping("/roles")
    @ApiOperation("Api for getting roles ")
    private ResponseEntity<List<Roles>> getRoles(@RequestParam String username) {

        return adminService.getRoles(username);

    }
    @PutMapping("/changestaterole")
    private BaseResponseDTO changeStateRole(@RequestParam Long id,@RequestParam String username)
    {
        return adminService.changeStateRole(id,username);
    }

    //--------ROLE MANAGER CRUD----------
    @PostMapping("/assign-role")
    @ApiOperation("Api for assigning a role ")
    private BaseResponseDTO assignRoles(@RequestBody AssignRolesRolesRequestDTO assignRolesRolesRequestDTO,@RequestParam String username) {
        return adminService.assignRoles(assignRolesRolesRequestDTO,username);
    }

    @PutMapping("/assign-role")
    @ApiOperation("Api for edit an assigned role ")
    private BaseResponseDTO editAssignedRole (@RequestParam int Id, @RequestBody AssignRolesRolesRequestDTO assignRolesRolesRequestDTO,@RequestParam String username) {
        return adminService.editAssignedRole(Id, assignRolesRolesRequestDTO,username);
    }

    @GetMapping("/assign-role")
    @ApiOperation("Api for getting assigned role ")
    private ResponseEntity<List<Admins>> getAssignedRole(@RequestParam String username) {

        return adminService.getAssignedRole(username);
    }
    @PutMapping("/changeassigned")
    private BaseResponseDTO changeAssignedRole(@RequestParam Long id,@RequestParam String username)
    {
        return adminService.changeAssignedRole(id,username);
    }
    @PostMapping("/Config")
    @ApiOperation("Api for assigning a role ")
    private BaseResponseDTO postconfig(@RequestBody ConfigRequestDTO configRequestDTO, @RequestParam String username) {
        return adminService.postconfig(configRequestDTO,username);
    }
    @GetMapping("/Config")
    @ApiOperation("Api for getting assigned role ")
    private ResponseEntity<List<Config>> getconfig(@RequestParam String username) {

        return adminService.getconfig(username);
    }


}