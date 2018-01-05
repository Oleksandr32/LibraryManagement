package com.project.librarymanagement.repository;

import com.project.librarymanagement.data.Book;
import com.project.librarymanagement.database.BooksTable;
import com.project.librarymanagement.database.MySqlConnector;
import com.project.librarymanagement.repository.specification.Specification;
import com.project.librarymanagement.repository.specification.SqlSpecification;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleksandr Lysun on 02.01.2018.
 * In this package, I implemented the pattern "Repository"
 */

public class BookRepository implements Repository<Book> {
    // data fields
    private static BookRepository instance;
    private static MySqlConnector mySqlConnector;

    // logging, I use log4j2
    private static final Logger logger = LogManager.getLogger( BookRepository.class );

    // init field
    static {
        instance = new BookRepository();
        mySqlConnector = MySqlConnector.getInstance();
    }

    private BookRepository() {
    }

    public static BookRepository getInstance() {
        if ( instance == null )
            instance = new BookRepository();

        return instance;
    }

    @Override
    public void add(Book book) throws SQLException {
        String query = String.format(
                "INSERT INTO %s(%s, %s) VALUES('%s', '%s')",
                BooksTable.DB_TABLE_NAME_KEY,
                BooksTable.Fields.NAME.getName(),
                BooksTable.Fields.AUTHOR.getName(),
                book.getName(), book.getAuthor()
        );

        logger.debug( query );

        mySqlConnector.createStatement().executeUpdate( query );
        mySqlConnector.closeConnect();
    }

    @Override
    public void remove(Book book) throws SQLException {
        String query = String.format(
                "DELETE FROM %s WHERE %s = '%s' AND %s = '%s'",
                BooksTable.DB_TABLE_NAME_KEY,
                BooksTable.Fields.NAME.getName(), book.getName(),
                BooksTable.Fields.AUTHOR.getName(), book.getAuthor()
        );

        logger.debug( query );

        mySqlConnector.createStatement().executeUpdate( query );
        mySqlConnector.closeConnect();
    }

    @Override
    public void update(Book oldBook, Book newBook) throws SQLException {
        String query = String.format(
                "UPDATE %s SET %s = '%s' WHERE %s = '%s' AND %s = '%s'",
                BooksTable.DB_TABLE_NAME_KEY,
                BooksTable.Fields.NAME.getName(), newBook.getName(),
                BooksTable.Fields.NAME.getName(), oldBook.getName(),
                BooksTable.Fields.AUTHOR.getName(), oldBook.getAuthor()
        );

        logger.debug( query );

        mySqlConnector.createStatement().executeUpdate( query );
        mySqlConnector.closeConnect();
    }

    @Override
    public List<Book> query(Specification specification) throws SQLException {
        List<Book> books = new ArrayList<Book>();

        SqlSpecification sqlSpecification = (SqlSpecification) specification;

        String query = sqlSpecification.toSqlQuery();
        logger.debug( query );

        ResultSet resultSet =  mySqlConnector.createStatement().executeQuery( query );

        while ( resultSet.next() ) {
            Book book = new Book(
                    resultSet.getInt( BooksTable.Fields.ID.getName() ), // 1
                    resultSet.getString( BooksTable.Fields.NAME.getName() ), // 2
                    resultSet.getString( BooksTable.Fields.AUTHOR.getName() ) // 3
            );

            books.add( book );
        }

        mySqlConnector.closeConnect();

        return books;
    }
}
