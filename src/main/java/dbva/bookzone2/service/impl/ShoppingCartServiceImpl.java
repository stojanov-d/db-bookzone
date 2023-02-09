package dbva.bookzone2.service.impl;

import dbva.bookzone2.model.Book;
import dbva.bookzone2.model.ShoppingCart;
import dbva.bookzone2.model.User;
import dbva.bookzone2.repository.BookRepository;
import dbva.bookzone2.repository.ShoppingCartRepository;
import dbva.bookzone2.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final BookRepository bookRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, BookRepository bookRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.bookRepository = bookRepository;
    }


    @Override
    public ShoppingCart findById(Integer id) {
        ShoppingCart shoppingCart = this.shoppingCartRepository.findById(id).orElseThrow();
        return shoppingCart;
    }

    @Override
    public ShoppingCart createNewShoppingCart(User user) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        shoppingCart.setBook(null);
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
    public ShoppingCart findByUserId(Integer id) {

        return this.shoppingCartRepository.findShoppingCartByUser_Id(id);
    }


}
