package dbva.bookzone2.service;

import dbva.bookzone2.model.Book;
import dbva.bookzone2.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    ShoppingCart findById(Integer id);

    ShoppingCart addToShoppingCart(String isbn,Integer id);

    void removeFromShoppingCart(String isbn,Integer id);

    ShoppingCart findByUserName(String name);
}
