package com.project.librarymanagement.command.invoker;

import com.project.librarymanagement.command.Command;
import com.project.librarymanagement.command.CommandEnum;
import com.project.librarymanagement.exception.ApplicationException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Oleksandr Lysun on 02.01.2018.
 * In this package are Invoker classes for the pattern "Command".
 */

public class CommandManager {
    // map with all commands
    private static Map<CommandEnum, Command> commands;

    // init map
    static { commands = new HashMap<CommandEnum, Command>( CommandEnum.size ); }

    // add command to map
    public static void addCommands(CommandEnum commandName, Command command) {
        commands.put( commandName, command );
    }

    // execute command
    public static void execute(CommandEnum command, List<String> args) {
        commands.get( command ).execute( args );
    }

}
