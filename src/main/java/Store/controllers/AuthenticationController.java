package Store.controllers;

import Store.model.User;
import Store.services.IUserService;
import Store.session.SessionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class AuthenticationController {

    @Autowired
    IUserService userService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("info", this.sessionObject.getInfo());



        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)

    public String login(@ModelAttribute User user, Model model) {
        model.addAttribute("info", this.sessionObject.getInfo());

        this.sessionObject.setUser(this.userService.authenticate(user));
        User loggedUser = userService.authenticate(user);

        if(this.sessionObject.getUser() != null) {
            return "redirect:/main";
        } else {
            this.sessionObject.setInfo("Nieprawidłowe Dane !!!");
            return "redirect:/login";

        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)

    public String logout() {

        this.sessionObject.setUser(null);

        return "redirect:/login";
    }



}
