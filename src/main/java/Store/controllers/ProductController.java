package Store.controllers;

import Store.model.Product;
import Store.services.IBrandService;
import Store.services.IProductService;
import Store.session.SessionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    SessionObject sessionObject;

    @Autowired
    IProductService productService;

    @Autowired
    IBrandService brandService;

    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    public String showAddProduct(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("info", this.sessionObject.getInfo());
        model.addAttribute("brands", this.brandService.getAllBrands());

        return "addProduct";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute Product product, Model model) {


        this.productService.addProduct(product);

        return "redirect:/addProduct";
    }
    @RequestMapping(value = "/allProduct", method = RequestMethod.GET)
    public String showAllProduct(Model model) {

        List<Product> products = this.productService.allProductList();
        model.addAttribute("products", products);


        return "allProduct";
    }

}
