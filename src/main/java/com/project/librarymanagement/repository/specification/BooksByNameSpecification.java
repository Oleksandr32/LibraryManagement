package com.project.librarymanagement.repository.specification;

import com.project.librarymanagement.database.BooksTable;

/**
 * Created by Oleksandr Lysun on 03.01.2018.
 * Specification for getting books by name.
 * For MySql.
 */

public class BooksByNameSpecification implements SqlSpecification {

    private final String name;

    public BooksByNameSpecification(String name) {
        this.name = name;
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                "SELECT * FROM %s WHERE %s = '%s'",
                BooksTable.DB_TABLE_NAME_KEY,
                BooksTable.Fields.NAME.getName(),
                name
        );
    }
}
