package Store.controllers;


import Store.model.Brand;
import Store.model.User;
import Store.services.IBrandService;
import Store.services.IProductService;
import Store.services.IUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin/utils")
public class AdminController {

    @Autowired
    IUserService userService;

    @Autowired
    IBrandService brandService;

    @Autowired
    IProductService productService;

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser() {
        User user = new User();
        user.setName("adminName");
        user.setSurname("adminSurname");
        user.setLogin("admin");
        String hashedPassword = DigestUtils.md5Hex("admin");
        user.setPassword(hashedPassword);
        user.setRole(User.Role.ADMIN);

        User user1 = new User();
        user1.setName("kamil");
        user1.setSurname("kamil");
        user1.setLogin("kamil");
        user1.setPassword("11d462a4a1b14b00580d8020d6f64998");
        user1.setRole(User.Role.USER);




        userService.addUser(user);
        userService.addUser(user1);

        return "redirect:/login";
    }

    @RequestMapping(value = "/addBrandDB", method = RequestMethod.GET)
    public String addBrandDB() {

        Brand brand1 = new Brand();
        brand1.setName("Brand1");
        brand1.setShortcut("B1");

        Brand brand2 = new Brand();
        brand2.setName("Brand2");
        brand2.setShortcut("B2");

        Brand brand3 = new Brand();
        brand3.setName("Brand3");
        brand3.setShortcut("B3");

        Brand brand4 = new Brand();
        brand4.setName("Brand4");
        brand4.setShortcut("B4");

        Brand brand5 = new Brand();
        brand5.setName("Brand5");
        brand5.setShortcut("B5");

        Brand brand6 = new Brand();
        brand6.setName("Brand6");
        brand6.setShortcut("B6");

        Brand brand7 = new Brand();
        brand7.setName("Brand7");
        brand7.setShortcut("B7");


        brandService.addBrand(brand1);
        brandService.addBrand(brand2);
        brandService.addBrand(brand3);
        brandService.addBrand(brand4);
        brandService.addBrand(brand5);
        brandService.addBrand(brand6);
        brandService.addBrand(brand7);


        return "redirect:/main";
    }
    //TODO dodać Warunki w html do validacji

}
