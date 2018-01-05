package com.project.librarymanagement.command;

/**
 * Created by Oleksandr Lysun on 03.01.2018.
 * Command enumeration
 */
public enum CommandEnum {
    // all commands
    GREET, HELP, ADD, REMOVE, EDIT, ALL_BOOKS, EXIT;

    // size of enumeration
    public static int size = CommandEnum.values().length;
}
