package com.travelbug.demo.services;


import com.travelbug.demo.dao.CartRepository;
import com.travelbug.demo.dao.CustomerRepository;
import com.travelbug.demo.entities.Cart;
import com.travelbug.demo.entities.CartItem;
import com.travelbug.demo.entities.Customer;
import com.travelbug.demo.entities.StatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CartRepository cartRepository;

    private CustomerRepository customerRepository;

    @Autowired
    public CheckoutServiceImpl(CartRepository cartRepository, CustomerRepository customerRepository) {
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
    }

    @Transactional
    @Override
    public PurchaseResponse checkoutCart(Purchase purchase) {
        Cart cart = purchase.getCart();

//        String orderTrackingNumber = generateOrderTrackingNumber();
//
//        cart.setOrderTrackingNumber(orderTrackingNumber);
//
//        Set<CartItem> cartItems = purchase.getCartItems();
//
//        cartItems.forEach(cartItem -> cart.add(cartItem));

        Customer customer = purchase.getCustomer();

        String orderTrackingNumber = generateOrderTrackingNumber();

        cart.setOrderTrackingNumber(orderTrackingNumber);

        cart.setStatus(StatusType.ordered);

        Set<CartItem> cartItems = purchase.getCartItems();

        cartItems.forEach(cartItem -> {
            cart.add(cartItem);
            cartItem.setCart(cart);
        });

        customer.add(cart);

        cart.setCustomer(customer);


        cartRepository.save(cart);
//        customerRepository.save(customer);


        return new PurchaseResponse(orderTrackingNumber);
















    }

    private String generateOrderTrackingNumber() {

        return UUID.randomUUID().toString();
    }
}
