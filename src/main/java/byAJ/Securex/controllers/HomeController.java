package byAJ.Securex.controllers;

import byAJ.Securex.models.NewUsers;
import byAJ.Securex.repositories.NewUserRepo;
import byAJ.Securex.repositories.UseRoleRepo;
import byAJ.Securex.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    NewUserRepo newUserRepo;
    @Autowired
    UseRoleRepo useRoleRepo;
    @Autowired
    private UserService userService;
    @RequestMapping("/")
    public String showHomePage() {
        return "homePage";
    }
    @RequestMapping("/index")
    public String index() {
        return "index";
    }
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    @RequestMapping(value="/signUpForm",method= RequestMethod.GET)
    public String showRegistrationPage(Model model) {
        model.addAttribute("newUser", new NewUsers());
        model.addAttribute("roleList", useRoleRepo.findAll());
        return "signUpForm";
    }
    @RequestMapping(value="/signUpForm",method=RequestMethod.POST)
    public String addUserConfirm(@Valid @ModelAttribute("newUser") NewUsers user, BindingResult bindingResult, Model model) {
        model.addAttribute("newUser",user);
        if(bindingResult.hasErrors()){
            return "signUpForm";
        }
        else if(user.getSelectVal().equalsIgnoreCase("USER"))        {

            userService.saveUser(user);
            model.addAttribute("message","User Account Successfully Created");
        }
        else
        {
            userService.saveAdmin(user);
            model.addAttribute("message","User Account Successfully Created");
        }
        return "signUpConfirm";

    }


}
