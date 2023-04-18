package com.GeekText.rest.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCartResultRow {
    private String book_title;
    private int user_id;
    private int book_id;
    private int quantity;
    private float subtotal;
}
