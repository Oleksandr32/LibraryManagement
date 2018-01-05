package com.project.librarymanagement.command.concretecommand;

import com.project.librarymanagement.command.Command;
import com.project.librarymanagement.command.receiver.Operation;
import com.project.librarymanagement.exception.ApplicationException;

import java.util.List;

/**
 * Created by Oleksandr Lysun on 02.01.2018.
 * In this package are Concrete command classes for the pattern "Command".
 */

public class AddBookCommand implements Command {
    // object of receiver
    private Operation operation;

    public AddBookCommand(Operation operation) { this.operation = operation; }

    public void execute(List<String> args) {
        // This command with arguments
        operation.addBook( args );
    }
}
