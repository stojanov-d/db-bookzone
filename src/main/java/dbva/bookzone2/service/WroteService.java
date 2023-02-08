package dbva.bookzone2.service;

import dbva.bookzone2.model.primarykeys.WroteID;
import dbva.bookzone2.model.relations.WroteRelation;

import java.util.HashMap;

public interface WroteService {

    HashMap<String,String> findAuthorsOfBooks();

    WroteRelation addAuthorToBook(String isbn,Integer authorId);

//    WroteRelation find(String isbn);

    WroteRelation editAuthorToBook(String isbn,Integer authorId);
}
