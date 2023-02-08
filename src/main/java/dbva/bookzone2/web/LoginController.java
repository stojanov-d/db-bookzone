package dbva.bookzone2.web;

import dbva.bookzone2.service.AuthService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private final AuthService authService;

    public LoginController(AuthService authService) {
        this.authService = authService;
    }


    @GetMapping("/login")
    public String loginPage(Model model){
        model.addAttribute("bodyContent","login");
        return "master-page";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session){
        UserDetails userDetails = this.authService.loginUser(username, password);
        session.setAttribute("user",userDetails);

        //TODO: Dodaj da se kreira nova kosnicka za ovaj user pri login
        return "redirect:/";
    }
}
