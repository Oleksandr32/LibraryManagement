package com.project.librarymanagement.repository.specification;

import com.project.librarymanagement.database.BooksTable;

/**
 * Created by Oleksandr Lysun on 03.01.2018.
 * Specification for getting all books.
 * For MySql.
 */

public class AllBooksSpecification implements SqlSpecification {

    @Override
    public String toSqlQuery() {
        return String.format(
                "SELECT * FROM %s",
                BooksTable.DB_TABLE_NAME_KEY
        );
    }
}
