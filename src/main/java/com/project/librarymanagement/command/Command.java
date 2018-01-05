package com.project.librarymanagement.command;

import com.project.librarymanagement.exception.ApplicationException;

import java.util.List;

/**
 * Created by Alex on 02.01.2018.
 * In this package, I implemented the pattern "Command"
 * the Command interface
 */
public interface Command {

    void execute(List<String> args);
}
