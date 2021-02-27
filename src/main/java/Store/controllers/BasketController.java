package Store.controllers;


import Store.model.Basket;
import Store.model.Product;
import Store.model.User;
import Store.services.IBasketService;
import Store.services.IProductService;
import Store.session.SessionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class BasketController {

    @Autowired
    IBasketService basketService;
    @Autowired
    IProductService productService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/basket", method = RequestMethod.GET)
    public String showAllBasket(Model model) {
        if (this.sessionObject.isLogged()) {
            model.addAttribute("basket", this.sessionObject.getBasket());
            model.addAttribute("user", this.sessionObject.getUser());

            return "basket";
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/addToBasket/{productId}", method = RequestMethod.GET)
    public String addProductToBasket(@PathVariable int productId) {
//TODO sprawdzanie zawartości koszyka i ewentualne zwiekszanie ilości 

        Product productFromDB = this.productService.getProductById(productId);

        if(productFromDB != null) {
            productFromDB.setPieces(productFromDB.getPieces() - 1);
            this.productService.updateProduct(productFromDB);
        }

        /*Basket basketFromDB = this.basketService.getProductByBarcode(barcode);
        if() {*/

            Basket basket = new Basket();


            basket.setName(productFromDB.getName());
            basket.setBrand(productFromDB.getBrand());
            basket.setBarcode(productFromDB.getBarcode());
            basket.setBox(productFromDB.getBox());
            basket.setPieces(1);
            basket.setCategory(productFromDB.getCategory());
            basket.setPrice(productFromDB.getPrice());
            basket.setStatus(Basket.Status.RESERVED);


            this.productService.addOrUpdateToBasket(basket);


            return "redirect:/allProduct";


    }




}
