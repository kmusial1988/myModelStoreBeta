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
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class UserController {
    @Autowired
    IUserService userService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegister(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("info", this.sessionObject.getInfo());

        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute User user,
                           @RequestParam String password2, Model model) {
        /* TODO Pattern compiledPattern = Pattern.compile(".*[0-9]+.*");
        Matcher matcher = compiledPattern.matcher(user.getPassword());
        matcher.matches();
        */
        if (!user.getPassword().equals(password2)) {
            this.sessionObject.setInfo("Nieprawidłowo powtórzone hasła !!!");
            return "redirect:/register";
        }

        boolean registerResult =
                this.userService.registerUser(user, password2);

        if(registerResult) {
            this.sessionObject.setInfo("Urzytkownik dodany !!!");
            return "redirect:/login";
        } else {
            this.sessionObject.setInfo("Nieprawidłowe dane1 !!!");
            return "redirect:/register";
        }
    }
    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String edit(Model model){
        if (this.sessionObject.isLogged()) {
            model.addAttribute("user", this.sessionObject.getUser());

            model.addAttribute("info", this.sessionObject.getInfo());
            this.sessionObject.setInfo(null);
            return "edit";
        }else {
            return "redirect:/login";
        }
    }


    @RequestMapping(value = "/changeData", method = RequestMethod.POST)
    public String changeData(@ModelAttribute User user) {

        user.setLogin(this.sessionObject.getUser().getLogin());
        User updateUser = this.userService.upgradeUser(user);
        this.sessionObject.setUser(updateUser);
        this.userService.addUser(updateUser);
//TODO zapis w bazie nie działa
        return "redirect:/edit";
    }
}
