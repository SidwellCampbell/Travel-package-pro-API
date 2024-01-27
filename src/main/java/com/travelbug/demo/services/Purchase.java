package com.travelbug.demo.services;

import com.travelbug.demo.entities.Cart;
import com.travelbug.demo.entities.CartItem;
import com.travelbug.demo.entities.Customer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Data
public class Purchase {

    private Customer customer;

    private Cart cart;

    private Set<CartItem> cartItems;




}
