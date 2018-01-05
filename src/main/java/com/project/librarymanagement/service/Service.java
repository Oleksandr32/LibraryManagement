package com.project.librarymanagement.service;

import com.project.librarymanagement.repository.specification.Specification;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Oleksandr Lysun on 03.01.2018.
 * In this package, I implemented the pattern "Service Locator"
 * For future modifications
 */

public interface Service<T> {

    String getName();

    void add(T item) throws SQLException;
    void remove(T item) throws SQLException;
    void update(T oldItem, T newItem) throws SQLException;

    List<T> query(Specification specification) throws SQLException;
}
