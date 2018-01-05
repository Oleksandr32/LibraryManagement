package com.project.librarymanagement.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Oleksandr Lysun on 03.01.2018.
 * Connect to MySQL 5.1.23 database.
 */

public class MySqlConnector {
    // data fields
    private static MySqlConnector instance;
    private static Connection connection;
    private static Statement statement;

    // logging, I use log4j2
    private static final Logger logger = LogManager.getLogger( MySqlConnector.class );

    // init dbconnector instance
    static {
        instance = new MySqlConnector();
        connection = null;
        statement = null;
    }

    // db constants
    private static final String DB_DRIVER_KEY = "com.mysql.jdbc.Driver";
    private static final String DB_URL_KEY = "jdbc:mysql://localhost:3306/library";
    private static final String DB_USER_KEY = "root";
    private static final String DB_PASSWORD_KEY = "root";

    private MySqlConnector() {
    }

    public static MySqlConnector getInstance() {
        if ( instance == null )
            instance = new MySqlConnector();

        return instance;
    }

    private Connection getConnection() {
        if ( connection == null ) {
            try {
                Class.forName( DB_DRIVER_KEY );
                logger.info("Driver loaded." );
                connection  = DriverManager.getConnection( DB_URL_KEY, DB_USER_KEY, DB_PASSWORD_KEY );
                logger.info("Database connected.");

            } catch (SQLException | ClassNotFoundException e){
                logger.error( "Connection failed.", e );
                e.printStackTrace();
            }
        }

        return connection;
    }

    public Statement createStatement() {
        if ( statement == null ) {
            try {
                statement = getConnection().createStatement();
                logger.info("Statement created successful.");
            } catch (SQLException e){
                logger.error("Statement failed.", e );
                e.printStackTrace();
            }
        }

        return statement;
    }

    public void closeConnect() {
        try {
            if (statement != null) {
                statement.close();
                statement = null;
                logger.info( "Statement closed." );
            }

            if (connection != null) {
                connection.close();
                connection = null;
                logger.info("Connection closed." );
            }

        } catch (SQLException e) {
            logger.error( e );
            e.printStackTrace();
        }
    }
}
