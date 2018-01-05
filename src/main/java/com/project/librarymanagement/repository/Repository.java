package com.project.librarymanagement.repository;

import com.project.librarymanagement.repository.specification.Specification;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Oleksandr Lysun on 02.01.2018.
 * In this package, I implemented the pattern "Repository"
 */
public interface Repository<T> {

    void add(T item) throws SQLException;
    void remove(T item) throws SQLException;
    void update(T oldItem, T newItem) throws SQLException;

    List<T> query(Specification specification) throws SQLException;
}
