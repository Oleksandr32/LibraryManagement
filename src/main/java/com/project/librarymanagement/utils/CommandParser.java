package com.project.librarymanagement.utils;

import com.project.librarymanagement.command.CommandEnum;
import com.project.librarymanagement.exception.ApplicationException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Oleksandr Lysun on 03.01.2018.
 * The command string should contain only one command
 */

public class CommandParser {

    // declaration list of all commands
    private static List<CommandEnum> commands;

    // init list of all commands
    static { commands = Arrays.asList( CommandEnum.values() ); }

    // find only one command in entered command string, if there is more or no return null
    public CommandEnum findOneCommand(String commandStr) {
        int count = 0;
        CommandEnum foundCommand = null;

        for (int i = 0; i < commands.size(); i++) {
            // replace because ALL_BOOKS in enum
            String foundCommandStr = commands.get( i ).toString().replace( "_", " " );
            if ( commandStr.toUpperCase().contains( foundCommandStr ) ) {
                foundCommand = commands.get( i );
                count++;
            }
        }

        return count == 1 ? foundCommand : null;
    }

    /**
     * method parses all commands and returns list of command arguments
     */
    public List<String> parseCommand(CommandEnum command, String commandStr) throws  ApplicationException {
        int index = command.ordinal();

        switch ( index ) {
            case 0:
                return parseCommandsWithoutArgs( command, commandStr );
            case 1:
                return parseCommandsWithoutArgs( command, commandStr );
            case 2:
                return parseAddCommand( command, commandStr );
            case 3:
                return parseCommandWithOneArg( command, commandStr );
            case 4:
                return parseCommandWithOneArg( command, commandStr );
            case 5:
                return parseCommandsWithoutArgs( command, commandStr );
            case 6:
                return parseCommandsWithoutArgs( command, commandStr );
            default:
                return null;
        }
    }

    // method parses given command as "greet", "help", "exit" or "all books" command
    private List<String> parseCommandsWithoutArgs(CommandEnum command, String commandStr) throws ApplicationException {
        // ignore all spaces and ignore case of entered command
        commandStr = commandStr.replaceAll( " ", "" );

        // replace because ALL_BOOKS in enum
        if ( commandStr.equalsIgnoreCase( command.toString().replace("_", "") ) )
            return null;
        else
            throw new ApplicationException( "You entered the command incorrectly or unknown command."
                    + "\nMaybe you wanted to enter \"greet\", \"help\", \"exit\" or \"all books\"."
                    + "\nSyntax: greet, help, exit, all books - without arguments and quotes!");
    }

    // method parses given command as "add" command
    private List<String> parseAddCommand(CommandEnum command, String commandStr) throws ApplicationException {
        String[] half = commandStr.trim().split( "\"" );

        String author = null;
        String name = null;

        String errorMessage = "You entered the command incorrectly or unknown command.\nMaybe you wanted to enter"
                + " \"add\" command.\nSyntax: add {author} {\"book_name\"}";

        if ( half.length != 2 ) {
            throw new ApplicationException( errorMessage );
        } else {
            String[] parts = half[0].trim().split( " " );

            if ( !parts[0].equalsIgnoreCase( command.toString() ) || parts.length == 1 ) {
                throw new ApplicationException( errorMessage );
            } else {
                name = half[1];
                author = Stream.of( parts ).filter(str -> !str.equalsIgnoreCase( "add" ) )
                        .collect(Collectors.joining(  " "));
            }
        }

        return Arrays.asList( author, name );
    }

    // method parses given command as "remove" or "edit" command
    private List<String> parseCommandWithOneArg(CommandEnum command, String commandStr) throws ApplicationException {
        String regex = command.toString().toLowerCase().concat( " " );
        String[] half = commandStr.trim().split( regex );

        if ( half.length != 2 ) {
            throw new ApplicationException("You entered the command incorrectly or unknown command."
                    + "\nMaybe you wanted to enter \"" + regex + "\" command."
                    + "\nSyntax: " + regex + "{book_name}" );
        }

        return Arrays.asList( half[1].trim() );
    }
}
