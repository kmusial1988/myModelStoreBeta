package Store.controllers;

import Store.model.Brand;
import Store.model.Product;
import Store.services.IBrandService;
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
public class BrandController {
    @Autowired
    SessionObject sessionObject;

    @Autowired
    IBrandService brandService;

    @RequestMapping(value = "/addBrand", method = RequestMethod.GET)
    public String showAddBrand(Model model) {


        model.addAttribute("brand", new Brand());
        model.addAttribute("info", this.sessionObject.getInfo());
        model.addAttribute("user", this.sessionObject.getUser());

        return "addBrand";
    }

    @RequestMapping(value = "/addBrand", method = RequestMethod.POST)
    public String addBrand(@ModelAttribute Brand brand, Model model) {
        model.addAttribute("user", this.sessionObject.getUser());
        this.brandService.addBrand(brand);

        return "redirect:/addBrand";
    }
    @RequestMapping(value = "/allBrand", method = RequestMethod.GET)
    public String showAllBrand(Model model) {

        List<Brand> brands = this.brandService.getAllBrands();
        model.addAttribute("brands", brands);
        model.addAttribute("user", this.sessionObject.getUser());
        return "allBrand";
    }

    @RequestMapping(value = "/filterBrand", method = RequestMethod.POST)

    //TODO nie dziala

    public String filterBrand(@RequestParam String patternBrand, Model model) {

        List<Brand> brands =this.brandService.findBrand(patternBrand);

        model.addAttribute("brands", brands);

        return "allBrand";
    }

}

