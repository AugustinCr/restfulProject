package com.GeekText.rest.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
public class Books {
    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int book_id;

    @Column(name = "title")
    private String title;

    @Column(name = "author_fname")
    private String author_fname;

    @Column(name = "author_lname")
    private String author_lname;

    @Column(name = "book_cost")
    private float book_cost;

}
