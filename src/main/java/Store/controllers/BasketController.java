package Store.controllers;


import Store.DAO.IProductDAO;
import Store.model.Basket;
import Store.model.Product;
import Store.model.User;
import Store.services.IBasketService;
import Store.services.IProductService;
import Store.session.SessionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class BasketController {

    @Autowired
    IBasketService basketService;

    @Autowired
    IProductService productService;

    @Resource
    SessionObject sessionObject;




    @RequestMapping(value = "/addToBasket/{productId}", method = RequestMethod.GET)
    public String addProductToBasket(@PathVariable int productId, Model model) {
//TODO sprawdzanie zawartości koszyka i ewentualne zwiekszanie ilości
        model.addAttribute("user", this.sessionObject.getUser());

        Product productFromDB = this.productService.getProductById(productId);

        if (productFromDB != null) {
            productFromDB.setPieces(productFromDB.getPieces() - 1);

        }
        this.basketService.addProductToBasket(productId);


        return "redirect:" + sessionObject.getLastAddress();
    }

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





        /*model.addAttribute("user", this.sessionObject.getUser());
        Product productFromDB = this.productService.getProductById(productId);
        List<Basket> productFromBasket = this.basketService.getBasketAllProductList();
        Basket basketFromDB = this.basketService.getProductByBarcode(basket.getBarcode());

        if (productFromDB != null) {
            productFromDB.setPieces(productFromDB.getPieces() - 1);
            this.productService.updateProduct(productFromDB);
        }


        if () {


            basketFromDB.setPieces(basketFromDB.getPieces() + 1);
            this.productService.addOrUpdateToBasket(basketFromDB);

        } else {
            Basket basket1 = new Basket();

            basket1.setName(productFromDB.getName());
            basket1.setBrand(productFromDB.getBrand());
            basket1.setBarcode(productFromDB.getBarcode());
            basket1.setBox(productFromDB.getBox());
            basket1.setPieces(1);
            basket1.setCategory(productFromDB.getCategory());
            basket1.setPrice(productFromDB.getPrice());
            basket1.setStatus(Basket.Status.RESERVED);


            this.productService.addOrUpdateToBasket(basket1);


        }
        return "redirect:" + sessionObject.getLastAddress();
    }*/
}

