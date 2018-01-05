package com.project.librarymanagement.data;

/**
 * Created by Oleksandr Lysun on 02.01.2018.
 */
public class Book {

    /*
      *  Date fields
     *   Optional parameter
     */
    private Integer id;

    // Required parameters
    private String name;
    private String author;

    // default constructor
    public Book() {
    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public Book(Integer id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != null ? !id.equals(book.id) : book.id != null) return false;
        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        return author != null ? author.equals(book.author) : book.author == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
