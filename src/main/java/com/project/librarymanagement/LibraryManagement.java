package com.project.librarymanagement;

import com.project.librarymanagement.command.CommandEnum;
import com.project.librarymanagement.command.concretecommand.*;
import com.project.librarymanagement.command.invoker.CommandManager;
import com.project.librarymanagement.command.receiver.Operation;
import com.project.librarymanagement.exception.ApplicationException;
import com.project.librarymanagement.utils.ConsoleIn;
import com.project.librarymanagement.utils.ConsoleOut;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;


/**
 * Created by Oleksandr Lysun on 01.01.2018.
 */

public class LibraryManagement {

    // logging, I use log4j2
    private static final Logger logger = LogManager.getLogger( LibraryManagement.class );

    // used the pattern "Command": here we add all objects of concrete commands with object of receiver to invoker map
    static {
        Operation operation = new Operation();
        CommandManager.addCommands( CommandEnum.GREET, new GreetCommand( operation ) );
        CommandManager.addCommands( CommandEnum.HELP, new HelpCommand( operation ) );
        CommandManager.addCommands( CommandEnum.ADD, new AddBookCommand( operation ) );
        CommandManager.addCommands( CommandEnum.REMOVE, new RemoveBookCommand( operation ) );
        CommandManager.addCommands( CommandEnum.EDIT, new EditBookCommand( operation ) );
        CommandManager.addCommands( CommandEnum.ALL_BOOKS, new AllBooksCommand( operation ) );
        CommandManager.addCommands( CommandEnum.EXIT, new ExitCommand( operation ) );
    }

    public static void main(String[] args) {
        // run application
        new LibraryManagement().run();
    }

    public void run()  {
        CommandManager.execute( CommandEnum.GREET, null );

        CommandEnum command = null;
        do {
            try {
                Map<CommandEnum, List<String>> commandMap = ConsoleIn.readCommand();
                command = commandMap.keySet().iterator().next();

                CommandManager.execute(command, commandMap.get(command));
            } catch ( ApplicationException e ) {
                logger.info( "Application Exception", e );
                ConsoleOut.printMessage( e.getMessage() );
            }

        } while ( command != CommandEnum.EXIT );
    }
}
