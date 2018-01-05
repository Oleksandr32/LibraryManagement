package com.project.librarymanagement.service;

import com.project.librarymanagement.data.Book;
import com.project.librarymanagement.repository.BookRepository;
import com.project.librarymanagement.repository.specification.Specification;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Oleksandr Lysun on 03.01.2018.
 * In this package, I implemented the pattern "Service Locator"
 * For future modifications
 */

public class BookService implements Service<Book> {
    // data field
    private BookRepository repository = BookRepository.getInstance();

    @Override
    public String getName() {
        return "BookService";
    }

    @Override
    public void add(Book book) throws SQLException {
        repository.add( book );
    }

    @Override
    public void remove(Book book) throws SQLException {
        repository.remove( book );
    }

    @Override
    public void update(Book oldBook, Book newBook) throws SQLException {
        repository.update( oldBook, newBook );
    }

    @Override
    public List<Book> query(Specification specification) throws SQLException {
        return repository.query( specification );
    }

}
