package dbva.bookzone2.service.impl;

import dbva.bookzone2.model.Book;
import dbva.bookzone2.model.ShoppingCart;
import dbva.bookzone2.model.User;
import dbva.bookzone2.model.exceptions.InvalidBookIdException;
import dbva.bookzone2.model.exceptions.InvalidUserIdException;
import dbva.bookzone2.repository.BookRepository;
import dbva.bookzone2.repository.ShoppingCartRepository;
import dbva.bookzone2.repository.UserRepository;
import dbva.bookzone2.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, BookRepository bookRepository, UserRepository userRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
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
        Book book = this.bookRepository.findById(isbn).orElseThrow(InvalidBookIdException::new);
        User user = this.userRepository.findById(id).orElseThrow(InvalidUserIdException::new);
        ShoppingCart shoppingCart = this.shoppingCartRepository.findShoppingCartByUser_Id(user.getId());

        shoppingCart.setBook(book);
        return this.shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public void removeFromShoppingCart(String isbn, Integer id) {

    }

    @Override
    public ShoppingCart findByUserId(Integer id) {

        return this.shoppingCartRepository.findShoppingCartByUser_Id(id);
    }


}
