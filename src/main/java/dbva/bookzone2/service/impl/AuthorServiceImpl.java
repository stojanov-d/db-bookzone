package dbva.bookzone2.service.impl;

import dbva.bookzone2.model.Author;
import dbva.bookzone2.repository.AuthorRepository;
import dbva.bookzone2.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }
}
