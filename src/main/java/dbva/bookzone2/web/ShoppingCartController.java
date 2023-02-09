package dbva.bookzone2.web;

import dbva.bookzone2.model.ShoppingCart;
import dbva.bookzone2.model.User;
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
        User user1 = this.userService.findByName(user.getUsername());
        if(user1.getShoppingCart()==null){
            ShoppingCart shoppingCart = this.shoppingCartService.createNewShoppingCart(user1);
            model.addAttribute("bodyContent",shoppingCart);
        }else{
            ShoppingCart shoppingCart = this.shoppingCartService.findByUserId(user1.getId());
            model.addAttribute("cart",shoppingCart);
        }
        model.addAttribute("bodyContent","shopping-cart");
        return "master-page";
    }
}
