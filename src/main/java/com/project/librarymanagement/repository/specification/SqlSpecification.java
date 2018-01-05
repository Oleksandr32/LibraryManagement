package com.project.librarymanagement.repository.specification;


/**
 * Created by Oleksandr Lysun on 04.01.2018.
 * Specification for MySql.
 */

public interface SqlSpecification extends Specification {

    String toSqlQuery();
}
