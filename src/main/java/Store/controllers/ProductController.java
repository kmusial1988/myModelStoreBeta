package Store.controllers;

import Store.model.Product;
import Store.services.IBrandService;
import Store.services.IProductService;
import Store.session.SessionObject;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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



    @RequestMapping(value = "/allCat", method = RequestMethod.GET)
    public String allCat(Model model){
        model.addAttribute("products", this.productService.allProductList());
        return "allProduct";
    }

    @RequestMapping(value = "/CAT1", method = RequestMethod.GET)
    public String cat1(Model model){
        model.addAttribute("products", this.productService.getProductByCategory(Product.Category.CAT1));
        return "allProduct";
    }

    @RequestMapping(value = "/CAT2", method = RequestMethod.GET)
    public String cat2(Model model){
        model.addAttribute("products", this.productService.getProductByCategory(Product.Category.CAT2));
        return "allProduct";
    }

    @RequestMapping(value = "/CAT3", method = RequestMethod.GET)
    public String cat3(Model model){
        model.addAttribute("products", this.productService.getProductByCategory(Product.Category.CAT3));
        return "allProduct";
    }

    @RequestMapping(value = "/CAT4", method = RequestMethod.GET)
    public String cat4(Model model){
        model.addAttribute("products", this.productService.getProductByCategory(Product.Category.CAT4));
        return "allProduct";
    }

    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public String filter(@RequestParam String pattern, Model model) {
        List<Product> products = this.productService.findProduct(pattern);
        model.addAttribute("products", products);




        return "allProduct";
    }


}
