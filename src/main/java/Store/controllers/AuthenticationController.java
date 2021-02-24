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

       /* if(sessionObject.getUser() == null) {
            model.addAttribute("isLogged", false);
            return "login";
        } else {
            return "redirect:/main";
        }*/

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)

    public String login(@ModelAttribute User user, Model model) {
        model.addAttribute("info", this.sessionObject.getInfo());
        boolean authenticationResult = userService.authenticate(user);

        if(authenticationResult) {
            this.sessionObject.setLogged(true);
            /*sessionObject.setUser(new User());*/
            return "redirect:/main";
        } else {
            this.sessionObject.setInfo("Nieprawidłowe Dane !!!");
            return "redirect:/login";

        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)

    public String logout() {

        this.sessionObject.setLogged(false);

        return "redirect:/login";
    }


}
