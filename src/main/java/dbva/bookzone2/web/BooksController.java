package dbva.bookzone2.web;

import dbva.bookzone2.model.Author;
import dbva.bookzone2.model.Book;
import dbva.bookzone2.model.User;
import dbva.bookzone2.service.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@Controller
public class BooksController {

    private final BookService bookService;
    private final WroteService wroteService;
    private final AuthorService authorService;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;

    public BooksController(BookService bookService, WroteService wroteService, AuthorService authorService, ShoppingCartService shoppingCartService, UserService userService) {
        this.bookService = bookService;
        this.wroteService = wroteService;
        this.authorService = authorService;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
    }

    @GetMapping({"/books","/"})
    public String showBooks(Model model){
        List<Book> books = this.bookService.listAll();
        HashMap<String,String> authorsOfBooks = this.wroteService.findAuthorsOfBooks();
        model.addAttribute("authors",authorsOfBooks);
        model.addAttribute("books",books);
        model.addAttribute("bodyContent","books");
        return "master-page";
    }

    @GetMapping("/books/add-book")
    public String addBook(Model model){
        List<Author> authorList = this.authorService.findAll();
        model.addAttribute("bodyContent","add-book");
        model.addAttribute("authorList",authorList);
        return "master-page";
    }

    @GetMapping("/books/{id}/edit-book")
    public String editBook(Model model,@PathVariable String id){
        Book book = this.bookService.findById(id);
        List<Author> authorList = this.authorService.findAll();
        model.addAttribute("book",book);
        model.addAttribute("bodyContent","add-book");
        model.addAttribute("authorList",authorList);
        return "master-page";
    }

    @PostMapping("/books")
    public String save(@RequestParam String isbn,
                       @RequestParam String title,
                       @RequestParam(required = false) Integer rating,
                       @RequestParam Boolean forSale,
                       @RequestParam Integer price,
                       @RequestParam Integer authorId){
        this.bookService.saveBook(isbn, title, rating, forSale, price);
        this.wroteService.addAuthorToBook(isbn,authorId);
        return "redirect:/books";
    }

    @PostMapping("/books/{id}")
    public String edit(@PathVariable String id,
                       @RequestParam String isbn,
                       @RequestParam String title,
                       @RequestParam(required = false) Integer rating,
                       @RequestParam Boolean forSale,
                       @RequestParam Integer price,
                       @RequestParam Integer authorId){
        this.wroteService.editAuthorToBook(isbn,authorId);
        this.bookService.editBook(id, isbn, title, rating, forSale, price);
        return "redirect:/books";
    }

    @PostMapping("/books/{id}/delete")
    public String delete(@PathVariable String id){
        this.bookService.delete(id);
        return "redirect:/books";
    }

    @PostMapping("/buy")
    public String addToShoppingCart(@RequestParam String isbn){
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user1 = this.userService.findByName(user.getUsername());
        this.shoppingCartService.addToShoppingCart(isbn,user1.getId());
        return "redirect:/shopping-cart";
    }


}