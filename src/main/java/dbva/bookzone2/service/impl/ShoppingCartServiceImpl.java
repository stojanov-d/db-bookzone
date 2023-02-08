package dbva.bookzone2.service.impl;

import dbva.bookzone2.model.Book;
import dbva.bookzone2.model.ShoppingCart;
import dbva.bookzone2.model.User;
import dbva.bookzone2.repository.BookRepository;
import dbva.bookzone2.repository.ShoppingCartRepository;
import dbva.bookzone2.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }


    @Override
    public ShoppingCart findById(Integer id) {
        ShoppingCart shoppingCart = this.shoppingCartRepository.findById(id).orElseThrow();
        return shoppingCart;
    }

    @Override
    public ShoppingCart createNewShoppingCart(User user) {
        ShoppingCart shoppingCart = new ShoppingCart(user);
        return this.shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ShoppingCart addToShoppingCart(String isbn, Integer id) {
        return null;
    }

    @Override
    public void removeFromShoppingCart(String isbn, Integer id) {

    }

    @Override
    public ShoppingCart findByUserName(String name) {

        return this.shoppingCartRepository.findShoppingCartByUser_Name(name);
    }


}
