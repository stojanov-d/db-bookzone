package dbva.bookzone2.web;

import dbva.bookzone2.model.ShoppingCart;
import dbva.bookzone2.service.ShoppingCartService;
import dbva.bookzone2.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ShoppingCartController {

    private final UserService userService;
    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(UserService userService, ShoppingCartService shoppingCartService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/shopping-cart")
    private String shoppingCartPage(Model model){
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ShoppingCart shoppingCart = this.shoppingCartService.findByUserName(user.getUsername());

        model.addAttribute("bodyContent","shopping-cart");
        model.addAttribute("cart",shoppingCart);
        return "master-page";
    }
}
