package dbva.bookzone2.web;

import dbva.bookzone2.service.AuthService;
import dbva.bookzone2.service.TypeService;
import dbva.bookzone2.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class RegisterController {

    private final UserService userService;
    private final TypeService typeService;
    private final AuthService authService;

    public RegisterController(UserService userService, TypeService typeService, AuthService authService) {
        this.userService = userService;
        this.typeService = typeService;
        this.authService = authService;
    }

    @GetMapping("/register")
    public String registerPage(Model model){

        model.addAttribute("bodyContent","register");

        return "master-page";
    }

    @PostMapping("/register")
    public String register(@RequestParam String name,
                           @RequestParam String surname,
                           @RequestParam String password,
                           @RequestParam String phoneNumber,
                           @RequestParam String type){
        Integer typeInt = Integer.parseInt(type);
        LocalDate currentDate = LocalDate.now();
        this.userService.register(name,surname,phoneNumber,password,currentDate,typeInt);
        this.authService.loginUser(name,password);
        return "redirect:/";
    }

}