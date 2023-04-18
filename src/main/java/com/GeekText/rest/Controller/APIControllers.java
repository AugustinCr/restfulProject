package com.GeekText.rest.Controller;

import com.GeekText.rest.Models.Books;
import com.GeekText.rest.Models.ShoppingCart;
import com.GeekText.rest.Models.ShoppingCartResultRow;
import com.GeekText.rest.Repo.BooksRepo;
import com.GeekText.rest.Repo.ShoppingCartRepo;
import org.hibernate.boot.jaxb.hbm.spi.EntityInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.repository.core.EntityInformation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class APIControllers {

    @Autowired
    private ShoppingCartRepo shoppingCartRepo;

    @Autowired
    private BooksRepo booksRepo;

    @GetMapping(value = "/")
    public String getPage() {
        return "Welcome";
    }

    @GetMapping(value = "/cart")
    public List<ShoppingCartResultRow> get(@RequestParam Integer userId) {
        if (userId == null) {
            return Collections.emptyList();
        }


        List<ShoppingCartResultRow> results = new ArrayList<>();

        List<ShoppingCart> findAllResult = shoppingCartRepo.findAll()
                .stream()
                .filter(s -> s.getUser_id() == userId)
                .toList();

        for (ShoppingCart shoppingCart : findAllResult) {
            ShoppingCartResultRow row = new ShoppingCartResultRow();
            row.setBook_id(shoppingCart.getBook_id());
            row.setUser_id(shoppingCart.getUser_id());
            row.setQuantity(shoppingCart.getQuantity());
            row.setSubtotal(shoppingCart.getSubtotal());

            Books book = booksRepo.findById(shoppingCart.getBook_id()).get();
            row.setBook_title(book.getTitle());

            results.add(row);
        }

        return results;
    }


    @GetMapping(value = "/cost")
    public Float getcost(@RequestParam Integer userId) {
        if (userId == null) {
            return 0.0F;
        }


        Float results = 0.0F;

        List<ShoppingCart> findAllResult = shoppingCartRepo.findAll()
                .stream()
                .filter(s -> s.getUser_id() == userId)
                .toList();

        for (ShoppingCart shoppingCart : findAllResult) {
            results += shoppingCart.getSubtotal();
        }

        return results;
    }



    

    @PostMapping(value = "/add")
    public String add(@RequestBody ShoppingCart shoppingCart) {
        shoppingCartRepo.save(shoppingCart);
        return "book added";
    }

    @DeleteMapping(value = "/delete")
    public String delete(@RequestBody ShoppingCart shoppingCart) {
        //ShoppingCart delete = shoppingCartRepo.findById(user_id).get();
        shoppingCartRepo.delete(shoppingCart);
        return "Book Removed";
    }
}
