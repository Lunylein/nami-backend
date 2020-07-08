package data

import groovy.sql.Sql

enum TestFixture implements Fixture {
    TEST_ENTITY_1("test1Name", "test1Description"),
    TEST_ENTITY_2("test2Name", "test2Description");

    final UUID id
    Long version
    Boolean deleted
    String name
    String description

    TestFixture(String name, String description, Long version = 0L, Boolean deleted = false){
        this.id = UUID.randomUUID()
        this.version = version
        this.deleted = deleted
        this.name = name
        this.description = description
    }

    @Override
    void insert(Sql sql) {
        sql.execute(
                "INSERT INTO tests (id, deleted, description, name, version) VALUES (?,?,?,?,?)", [id, deleted, description, name, version]
        )
    }

    @Override
    void delete(Sql sql) {
        sql.execute(
                "DELETE FROM tests WHERE id = ?", [id]
        )
    }
}