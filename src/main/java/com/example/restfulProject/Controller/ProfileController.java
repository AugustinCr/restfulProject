package com.example.restfulProject.Controller;

import com.example.restfulProject.Model.Card;
import com.example.restfulProject.Model.User;
import com.example.restfulProject.Repository.CardRepository;
import com.example.restfulProject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfileController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CardRepository cardRepository;

    @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user) {
        userRepository.save(user);
        return "Saved...";
    }

    @GetMapping(value = "/user/{username}")
    public List<User> getUser(@PathVariable String username) {
        return userRepository.findAllByUsername(username);
    }

    @PutMapping(value = "/update/{username}")
    public String updateUser(@PathVariable String username, @RequestBody User user) {
        User updateUser = userRepository.findByUsername(username);
        updateUser.setUsername(user.getUsername());
        updateUser.setPassword(user.getPassword());
        updateUser.setName(user.getName());
        updateUser.setAddress(user.getAddress());
        userRepository.save(updateUser);
        return "Updated...";
    }

    @PostMapping(value = "/save/card/{username}")
    public String updateUserCredit(@PathVariable String username, @RequestBody Card card) {
        Card userCard = card;
        User foundUser = userRepository.findByUsername(username);
        long userID = foundUser.getUserID();

        userCard.setUserID(userID);
        userCard.setCardnumber(card.getCardnumber());
        userCard.setExpirationdate(card.getExpirationdate());
        userCard.setSecuritycode(card.getSecuritycode());

        cardRepository.save(userCard);
        return "Added...";
    }

    @GetMapping(value = "/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @DeleteMapping(value = "/delete/{userID}")
    public String deleteUser(@PathVariable long userID) {
        User deleteUser = userRepository.findById(userID).get();
        userRepository.delete(deleteUser);
        return "User Deleted...";
    }

    @GetMapping(value = "/cards")
    public List<Card> getCards() {
        return cardRepository.findAll();
    }

    @DeleteMapping(value = "/delete/card/{userID}")
    public String deleteCard(@PathVariable long userID) {
        Card deleteCard = cardRepository.findById(userID).get();
        cardRepository.delete(deleteCard);
        return "Card Deleted...";
    }
}