package com.example.restfulProject.Repository;

import com.example.restfulProject.Model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
