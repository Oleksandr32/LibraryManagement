package com.project.librarymanagement.utils;

import com.project.librarymanagement.command.CommandEnum;
import com.project.librarymanagement.exception.ApplicationException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Oleksandr Lysun on 03.01.2018.
 */

public class Converter {
    // parser for string of command
    private static CommandParser commandParser;

    // init parser
    static { commandParser = new CommandParser(); }

    // convert string with command to Map -> key = CommandEnum, value = List of arguments
    public static Map<CommandEnum, List<String>> convertCommandToMap(String commandStr) throws ApplicationException {
        Map<CommandEnum, List<String>> commandMap = new HashMap<CommandEnum, List<String>>(1);

        CommandEnum command = commandParser.findOneCommand( commandStr );

        if ( command == null )
            throw new ApplicationException( "You entered the command incorrectly or unknown command." );

        List<String> args = commandParser.parseCommand( command, commandStr );
        commandMap.put( command, args );

        return commandMap;
    }
}
