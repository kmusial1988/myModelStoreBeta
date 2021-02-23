package Store.controllers;

import Store.model.Product;
import Store.services.IProductService;
import Store.session.SessionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class CommonController {

    @Resource
    SessionObject sessionObject;

    @Autowired
    IProductService productService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String commonRedirect() {
        return "redirect:/login";

    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model) {



        return "main";
    }

    /*@RequestMapping(value = "/filter", method = RequestMethod.POST)
    public String filter() {


    }*/


}
