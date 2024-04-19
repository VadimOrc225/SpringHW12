package org.gb.springbootlesson3.entity;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "book")
@Data
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String name;

    public Book() {
    }

    public Book(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Id: " + id + " Title: " + name;
    }
}
