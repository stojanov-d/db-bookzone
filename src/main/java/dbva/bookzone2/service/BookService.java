package dbva.bookzone2.service;

import dbva.bookzone2.model.Book;

import java.util.List;

public interface BookService {

    List<Book> listAll();

    Book findById(String id);

    Book saveBook(String isbn,String title, Integer rating, Boolean forSale, Integer price);

    Book editBook(String isbnToEdit,String isbn,String title,Integer rating, Boolean forSale, Integer price);

    void delete(String isbn);
}
