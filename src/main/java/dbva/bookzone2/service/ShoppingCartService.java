package dbva.bookzone2.service;

import dbva.bookzone2.model.Book;
import dbva.bookzone2.model.ShoppingCart;
import dbva.bookzone2.model.User;

import java.util.List;

public interface ShoppingCartService {

    ShoppingCart findById(Integer id);

    ShoppingCart createNewShoppingCart(User user);

    ShoppingCart addToShoppingCart(String isbn,Integer id);

    void removeFromShoppingCart(String isbn,Integer id);

    ShoppingCart findByUserId(Integer id);
}
