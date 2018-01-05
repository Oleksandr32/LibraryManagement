package com.project.librarymanagement.command.receiver;

import com.project.librarymanagement.data.Book;
import com.project.librarymanagement.repository.specification.*;
import com.project.librarymanagement.service.Service;
import com.project.librarymanagement.service.ServiceLocator;
import com.project.librarymanagement.utils.ConsoleIn;
import com.project.librarymanagement.utils.ConsoleOut;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

import java.util.List;

/**
 * Created by Oleksandr Lysun on 03.01.2018.
 * In this package are Receiver classes for the pattern "Command".
 */

public class Operation {
    // data field
    private Service service;

    // logging, I use log4j2
    private static final Logger logger = LogManager.getLogger( Operation.class );

    public Operation() {
        service = ServiceLocator.getService( "BookService" ) ;
    }

    public void greet() {
        ConsoleOut.printGreetingMessage();
    }

    public void exit() {
        ConsoleOut.printExitMessage();
    }

    public void help() { ConsoleOut.printHelpInfo(); }

    public void allBooks() {
        List<Book> books = null;

        AllBooksSpecification specification = new AllBooksSpecification();

        try {
            books = service.query( specification );
        } catch (SQLException e) {
            logger.error( e );
            e.printStackTrace();
        }

        if ( !books.isEmpty() ) {
            ConsoleOut.printMessage( String.format( "  Our books:\n\t%-25s\t%s", "Author", "Name" ) );

            books.forEach(book -> ConsoleOut.printMessage(
                    String.format( "\n\t%-25s\t\"%s\"", book.getAuthor(), book.getName() ) )
            );
        } else {
            ConsoleOut.printMessage("There are no books in the library");
        }
    }

    public void addBook(List<String> args) {
        List<Book> books = null;

        String author = args.get( 0 );
        String name = args.get( 1 );

        BooksByNameAndAuthorSpecification specification
                = new BooksByNameAndAuthorSpecification( name, author );
        try {
            books = service.query( specification );

            if ( books.isEmpty() ) {
                service.add(new Book(name, author));

                ConsoleOut.printMessage( String.format( "book %s \"%s\" was added", author, name) );
                logger.info( "The book "+author+" \""+name+"\" was added" );
            } else
                ConsoleOut.printMessage( "This book is already in the library" );

        } catch (SQLException e ) {
            logger.info( "The book "+author+" \""+name+"\" was not added", e );
            e.printStackTrace();
        }
    }

    private Book findBook(List<String> args) {
        List<Book> books = null;

        String name = args.get(0);
        BooksByNameSpecification specification = new BooksByNameSpecification( name );

        try {
            books = service.query( specification );

            if ( books.size() > 1 ) {
                ConsoleOut.printMessage( "we have few books with such name please choose one by " +
                        "typing a number of book:\n" );
                for (int i = 0; i < books.size(); i++) {
                    ConsoleOut.printMessage(String.format("%d.  %s  \"%s\"\n",
                            (i + 1), books.get( i ).getAuthor(), books.get( i ).getName() ));
                }

                int request = ConsoleIn.readNumber( 1, books.size() ) - 1;
                if ( request != -2 ) // -1 - 1 == 2
                    return books.get( request );

            } else if ( books.size() == 1 ) {
                return books.get( 0 );
            } else
                ConsoleOut.printMessage( "book with name \"" + name + "\" is not in the library" );

        } catch (SQLException e) {
            logger.error( e );
            e.printStackTrace();
        }

        return null;
    }

    public void removeBook(List<String> args) {
        Book book = findBook(args);

        if (book != null) {
            try {
                service.remove(book);
                ConsoleOut.printMessage(String.format("book %s \"%s\" was removed",
                        book.getAuthor(), book.getName()));
                logger.info( "book "+ book.getAuthor()+" \""+book.getName()+"\" was removed." );
            } catch (SQLException e) {
                logger.info( "book "+ book.getAuthor()+" \""+book.getName()+"\" was not removed." );
                e.printStackTrace();
            }
        }
    }

    public void  editBook(List<String> args) {
        Book book = findBook( args );

        if ( book != null ) {
            try {
                String newName = ConsoleIn.readName();
                if ( newName != null ) {
                    service.update( book, new Book( newName, book.getAuthor() ) );

                    ConsoleOut.printMessage(String.format("book %s \"%s\" was renamed to \"%s\"",
                            book.getAuthor(), book.getName(), newName ));
                    logger.info( "book "+ book.getAuthor()+" \""+book.getName()+"\" was renamed." );
                }
            } catch (SQLException e) {
                logger.info( "book "+ book.getAuthor()+" \""+book.getName()+"\" was not renamed." );
                e.printStackTrace();
            }
        }
    }
}
