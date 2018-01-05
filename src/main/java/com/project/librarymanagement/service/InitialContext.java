package com.project.librarymanagement.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Oleksandr Lysun on 03.01.2018.
 * In this package, I implemented the pattern "Service Locator"
 * For future modifications
 */

public class InitialContext {

    // logging, I use log4j2
    private static final Logger logger = LogManager.getLogger( InitialContext.class );

    public Object lookup(String name){

        if( name.equalsIgnoreCase( "BookService" ) ){
            logger.info("Looking up and creating a new BooksService object" );
            return new BookService();
        }

        return null;
    }
}
