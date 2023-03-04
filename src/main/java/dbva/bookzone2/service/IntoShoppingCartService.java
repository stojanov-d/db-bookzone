package dbva.bookzone2.service;

import dbva.bookzone2.model.Book;
import dbva.bookzone2.model.relations.IntoShoppingCartRelation;

import java.util.List;

public interface IntoShoppingCartService {

    List<Book> showAllBooksInCart(Integer cartId);

    IntoShoppingCartRelation addBookToShoppingCart(String bookId,Integer cartId);

    void removeBookFromCart(String id,Integer cartId);
}
