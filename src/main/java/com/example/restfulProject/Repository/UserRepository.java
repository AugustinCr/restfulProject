package com.example.restfulProject.Repository;

import com.example.restfulProject.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByUsername(String username);
    User findByUsername(String username);
}