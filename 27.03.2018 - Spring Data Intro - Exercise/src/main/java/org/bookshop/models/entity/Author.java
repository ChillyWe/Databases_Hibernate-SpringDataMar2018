package org.bookshop.models.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author {
    private Long id;
    private String firstName;
    private String lastName;
    private Set<Book> books;

    public Author() {
        this.books = new HashSet<>();
    }

    public Author(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getAuthorId() {
        return id;
    }

    public void setAuthorId(Long authorId) {
        this.id = authorId;
    }

    @Column
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @OneToMany(mappedBy = "author")
    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}