package com.project.librarymanagement.database;

/**
 * Created by Oleksandr Lysun on 03.01.2018.
 */

public class BooksTable {
    // table name
    public static final String DB_TABLE_NAME_KEY = "books";

    public enum Fields {

        ID("id", "INT", 11, 1), // 1
        NAME("name", "VARCHAR", 45, 2), // 2
        AUTHOR("author", "VARCHAR", 45, 3); // 3

        private final String name;
        private final String type;
        private final int length;
        private final int column;

        Fields(String name, String type, int length, int column) {
            this.name = name;
            this.type = type;
            this.length = length;
            this.column = column;
        }

        public String getType() {
            return type;
        }

        public String getName() {
            return name;
        }

        public int getLength() {
            return length;
        }

        public int getColumn() {
            return column;
        }
    }
}
