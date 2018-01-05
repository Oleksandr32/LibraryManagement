package com.project.librarymanagement.utils;

/**
 * Created by Oleksandr Lysun on 02.01.2018.
 */

public class ConsoleOut {

    // print any message to the console
    public static void printMessage(String message){
        System.out.print( message );
    }

    public static void printGreetingMessage() {
        ConsoleOut.printMessage(
                "\t\t\t\t\t\t WELCOME AT LIBRARY MANAGEMENT"
              + "\n-------------------------------------------------------------------------------------"
              + "\nEnter the command \"help\" if you want to get a list of all commands with description"
              + "\n-------------------------------------------------------------------------------------"
              + "\nPlease enter a command desired or type 'exit' for exit the program"
        );
    }

    public static void printExitMessage() {
        ConsoleOut.printMessage( "Thank you for using our Library Management\nGood luck ;-)" );
    }

    public static void  printHelpInfo() {
        ConsoleOut.printMessage(
                "* help - prints a list of all commands with description. Syntax: help"
                + "\n* greet - prints greeting message to console. Syntax: greet"
                + "\n* add - adds new book to the library. Syntax: add {author} {\"book_name\"}"
                + "\n* remove - removes the book from the library. Syntax: remove {book_name}"
                + "\n* edit - allows you to change the name of the book. Syntax: edit {book_name}"
                + "\n* all books - prints all books to console. Syntax: all books"
                + "\n* exit - stops program work. Syntax: exit."
        );
    }
}
