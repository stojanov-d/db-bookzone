package dbva.bookzone2.web;

import dbva.bookzone2.model.User;
import dbva.bookzone2.service.AuthService;
import dbva.bookzone2.service.ShoppingCartService;
import dbva.bookzone2.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private final AuthService authService;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;

    public LoginController(AuthService authService, UserService userService, ShoppingCartService shoppingCartService) {
        this.authService = authService;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
    }


    @GetMapping("/login")
    public String loginPage(Model model){
        model.addAttribute("bodyContent","login");
        return "master-page";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session){
        UserDetails userDetails = this.authService.loginUser(username, password);
        if(userDetails==null){
            return "redirect:/register";
        }

        session.setAttribute("user",userDetails);


        return "redirect:/";
    }
}
