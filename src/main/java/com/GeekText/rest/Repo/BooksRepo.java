package com.GeekText.rest.Repo;

import com.GeekText.rest.Models.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepo extends JpaRepository <Books, Integer> {
}
