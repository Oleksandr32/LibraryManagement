package com.project.librarymanagement.repository.specification;

import com.project.librarymanagement.database.BooksTable;

/**
 * Created by Oleksandr Lysun on 03.01.2018.
 * Specification for getting books by name and author.
 * For MySql.
 */

public class BooksByNameAndAuthorSpecification implements SqlSpecification {

    private final String name;
    private final String author;

    public BooksByNameAndAuthorSpecification(String name, String author) {
        this.name = name;
        this.author = author;
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                "SELECT * FROM %s WHERE %s = '%s' AND %s = '%s'",
                BooksTable.DB_TABLE_NAME_KEY,
                BooksTable.Fields.NAME.getName(),
                name,
                BooksTable.Fields.AUTHOR.getName(),
                author
        );
    }
}
