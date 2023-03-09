package com.example.restfulProject.Repository;

import com.example.restfulProject.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}