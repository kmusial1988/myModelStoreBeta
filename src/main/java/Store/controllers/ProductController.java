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


    @RequestMapping(value = "/allProduct", method = RequestMethod.GET)
    public String showAllProduct(Model model, @RequestParam(defaultValue = "none") String subpage) {

        if (sessionObject.isLogged()) {
//TODO nie wyszukuje wszedzie w każdej kategori tylko w default
            switch (subpage) {
                case "allCat":
                    model.addAttribute("products", this.productService.allProductList());
                    break;
                case "CAT1":
                    model.addAttribute("products", this.productService.getProductByCategory(Product.Category.CAT1));
                    break;
                case "CAT2":
                    model.addAttribute("products", this.productService.getProductByCategory(Product.Category.CAT2));
                    break;
                case "CAT3":
                    model.addAttribute("products", this.productService.getProductByCategory(Product.Category.CAT3));
                    break;
                case "CAT4":
                    model.addAttribute("products", this.productService.getProductByCategory(Product.Category.CAT4));
                    break;
                default:
                    if (this.sessionObject.getFilter() == null) {
                        model.addAttribute("products", this.productService.allProductList());
                    } else {
                        model.addAttribute("products", this.productService.findProduct(this.sessionObject.getFilter()));
                        model.addAttribute("pattern", this.sessionObject.getFilter());
                    }
                    break;
            }

            model.addAttribute("user", this.sessionObject.getUser());
            return "allProduct";
        } else {

            return "redirect:/login";
        }
    }


    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public String filter(@RequestParam String pattern, Model model) {
        if (sessionObject.isLogged()) {
            this.sessionObject.setFilter(pattern);
            List<Product> products = this.productService.findProduct(pattern);
            model.addAttribute("products", products);
            model.addAttribute("user", this.sessionObject.getUser());


            return "redirect:/allProduct";
        } else {
            return "redirect:/login";
        }

    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    public String showAddProduct(Model model) {
        if (sessionObject.isLogged()) {
            model.addAttribute("product", new Product());
            model.addAttribute("info", this.sessionObject.getInfo());
            model.addAttribute("brands", this.brandService.getAllBrands());
            model.addAttribute("user", this.sessionObject.getUser());

            return "addProduct";
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute Product product, Model model) {
        if (sessionObject.isLogged()) {
            model.addAttribute("user", this.sessionObject.getUser());
            Product productFromDB = this.productService.getProductByBarcode(product.getBarcode());

            if (productFromDB != null) {
                /*productFromDB.setPieces(productFromDB.getPieces() + product.getPieces());
                this.productService.updateProduct(productFromDB);*/
                this.sessionObject.setInfo("Produkt Już istnieje !!!");
                return "redirect:/addProduct";

            } else {
                if (product.getName().equals("") || product.getBarcode().equals("") || product.getPieces() == 0 || product.getPrice() == 0.0) {
                    this.sessionObject.setInfo("Uzupełnij dane !!!");
                } else {

                    this.productService.addProduct(product);
                    this.sessionObject.setInfo("Dodano nowy produkt !!!");
                }
            }
            return "redirect:/addProduct";
        } else {
            return "redirect:/login";
        }
    }
}
