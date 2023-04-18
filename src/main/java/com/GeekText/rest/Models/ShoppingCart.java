package com.GeekText.rest.Models;

import jakarta.persistence.*;

@Entity
@IdClass(ShoppingCart.class)
@Table(name = "shopping_cart")
public class ShoppingCart {

    @Id
    @Column(name = "user_id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

    @Id
    @Column(name = "book_id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int book_id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "subtotal",precision=4, scale=2)
    private float subtotal;


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }
}
