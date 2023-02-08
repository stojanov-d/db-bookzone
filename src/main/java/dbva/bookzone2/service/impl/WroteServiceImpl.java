package dbva.bookzone2.service.impl;

import dbva.bookzone2.model.Author;
import dbva.bookzone2.model.primarykeys.WroteID;
import dbva.bookzone2.model.relations.WroteRelation;
import dbva.bookzone2.repository.AuthorRepository;
import dbva.bookzone2.repository.BookRepository;
import dbva.bookzone2.repository.WroteRepository;
import dbva.bookzone2.service.WroteService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
public class WroteServiceImpl implements WroteService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final WroteRepository wroteRepository;

    public WroteServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, WroteRepository wroteRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.wroteRepository = wroteRepository;
    }


    @Override
    public HashMap<String, String> findAuthorsOfBooks() {
        HashMap<String,Integer> booksAuthorsMap = new HashMap<>();
        List<WroteRelation> wroteRelationList = this.wroteRepository.findAll();
        List<Author> authors = this.authorRepository.findAll();

        wroteRelationList.forEach(el -> booksAuthorsMap.put(el.getWroteID().getBookId(),el.getWroteID().getAuthorId()));

        HashMap<String,String> mappedBookAuthor = new HashMap<>();
        booksAuthorsMap.forEach((k,v)-> mappedBookAuthor.put(k,authors.get(v-1).getName()+" "+authors.get(v-1).getSurname()));

        return mappedBookAuthor;
    }

    @Override
    public WroteRelation addAuthorToBook(String isbn, Integer authorId) {
        WroteID wroteID = new WroteID(isbn,authorId);
        WroteRelation wroteRelation = new WroteRelation(wroteID);
        wroteRelation.getWroteID().setAuthorId(authorId);
        wroteRelation.getWroteID().setBookId(isbn);
        return this.wroteRepository.save(wroteRelation);
    }

    @Override
    public WroteRelation editAuthorToBook(String isbn,Integer authorId) {
        List<WroteRelation> wroteRelationList = this.wroteRepository.findAll();
        WroteRelation result = new WroteRelation();
        for(WroteRelation wr : wroteRelationList){
            WroteID wroteID = wr.getWroteID();
            if(wroteID.getBookId().equals(isbn)){
                result.setWroteID(wroteID);
            }
        }
        result.getWroteID().setAuthorId(authorId);
        return this.wroteRepository.save(result);
    }


}
