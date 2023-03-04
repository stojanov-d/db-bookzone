package dbva.bookzone2.service.impl;

import dbva.bookzone2.model.Book;
import dbva.bookzone2.model.exceptions.InvalidBookIdException;
import dbva.bookzone2.model.primarykeys.IntoShoppingCartID;
import dbva.bookzone2.model.relations.IntoShoppingCartRelation;
import dbva.bookzone2.repository.BookRepository;
import dbva.bookzone2.repository.IntoShoppingCartRepository;
import dbva.bookzone2.service.IntoShoppingCartService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class IntoShoppingCartServiceImpl implements IntoShoppingCartService {

    private final IntoShoppingCartRepository intoShoppingCartRepository;
    private final BookRepository bookRepository;

    public IntoShoppingCartServiceImpl(IntoShoppingCartRepository intoShoppingCartRepository, BookRepository bookRepository) {
        this.intoShoppingCartRepository = intoShoppingCartRepository;
        this.bookRepository = bookRepository;
    }


    @Override
    public List<Book> showAllBooksInCart(Integer cartId) {
        List<IntoShoppingCartRelation> booksInShoppingCart = this.intoShoppingCartRepository.findAllById_ShoppingCartId(cartId);
        List<Book> books = new ArrayList<>();

        for(IntoShoppingCartRelation intoShoppingCartRelation : booksInShoppingCart){
            Book book = this.bookRepository.findById(intoShoppingCartRelation.getId().getBookId()).orElseThrow(InvalidBookIdException::new);
            books.add(book);
        }
        return books;
    }

    @Override
    public IntoShoppingCartRelation addBookToShoppingCart(String bookId, Integer cartId) {
        IntoShoppingCartID intoShoppingCartID = new IntoShoppingCartID(bookId,cartId);
        IntoShoppingCartRelation intoShoppingCartRelation = new IntoShoppingCartRelation(intoShoppingCartID);
        intoShoppingCartRelation.getId().setShoppingCartId(cartId);
        intoShoppingCartRelation.getId().setBookId(bookId);
        return this.intoShoppingCartRepository.save(intoShoppingCartRelation);
    }

    @Override
    @Transactional
    public void removeBookFromCart(String id, Integer cartId) {
        this.intoShoppingCartRepository.deleteById_BookIdAndId_ShoppingCartId(id,cartId);
    }


}
