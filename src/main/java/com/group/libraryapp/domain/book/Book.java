package com.group.libraryapp.domain.book;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    public Book(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(String.format("wrong argument: %s", name));
        }
        this.name = name;
    }

    protected Book() {

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
