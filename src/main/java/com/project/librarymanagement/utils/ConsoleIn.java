package com.project.librarymanagement.utils;

import com.project.librarymanagement.command.CommandEnum;
import com.project.librarymanagement.exception.ApplicationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.List;
import java.util.Map;

/**
 * Created by Oleksandr Lysun on 02.01.2018.
 */

public class ConsoleIn {

    // logging, I use log4j2
    private static final Logger logger = LogManager.getLogger( ConsoleIn.class );

    // use BufferedReader for reading lines
    private static BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

    // method for reading lines from the console
    public static String readString()  {
        String input = null;
        try {
            input = reader.readLine();
        }catch (IOException e){
            logger.error( e );
            e.printStackTrace();
        }

        return input;
    }

    // method for reading command from the console
    public static Map<CommandEnum, List<String>> readCommand() throws ApplicationException {
        ConsoleOut.printMessage( "\n$ " );

        String commandStr = readString();
        Map<CommandEnum, List<String>> commandMap = Converter.convertCommandToMap( commandStr );

        if( commandMap.containsKey( CommandEnum.EXIT ) ){
            ConsoleOut.printMessage( "Do you really want to exit? <y,n>: " );

            String request = readString();
            if( request.equalsIgnoreCase("n") || request.equalsIgnoreCase("no") ){
                readCommand();
            }
        }

        return commandMap;
    }

    // the method reads the number in the appropriate range from the console
    public static int readNumber(int min, int max) {
        ConsoleOut.printMessage( String.format( "Enter a number from the range [%d, %d] " +
                "or \"back\" to go back\n$ ", min, max ) );

        String requestStr = null;
        while ( !(requestStr = readString()).equalsIgnoreCase( "back" ) ) {
            String warningMessage = "Invalid input. Try again: ";
            try {
                int requestNum = Integer.parseInt( requestStr );
                if ( requestNum >= min && requestNum <= max ) {
                    return requestNum;
                } else
                    ConsoleOut.printMessage( warningMessage );
            } catch (NumberFormatException e) {
                ConsoleOut.printMessage( warningMessage );
            }
        }

        return -1;
    }

    // the method reads the new name for book from the console
    public static String readName() {
        ConsoleOut.printMessage( "Enter a new name {book_name} or \"back\" to go back\n$ " );

        String request = null;
        while ( !(request = readString()).equalsIgnoreCase( "back" ) ) {
            if ( request.isEmpty() )
                ConsoleOut.printMessage( "Invalid input. Try again: " );
            else
                return request;
        }

        return null;
    }
}
