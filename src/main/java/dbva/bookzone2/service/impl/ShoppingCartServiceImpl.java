package dbva.bookzone2.service.impl;

import dbva.bookzone2.model.Book;
import dbva.bookzone2.model.ShoppingCart;
import dbva.bookzone2.repository.BookRepository;
import dbva.bookzone2.repository.ShoppingCartRepository;
import dbva.bookzone2.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;

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


}
