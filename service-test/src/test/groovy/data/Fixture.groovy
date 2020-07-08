package data

import groovy.sql.Sql

interface Fixture {
    void insert(Sql sql)
    void delete(Sql sql)
}
