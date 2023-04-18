package com.GeekText.rest.Repo;

import com.GeekText.rest.Models.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepo extends JpaRepository<ShoppingCart, Integer> {
}
