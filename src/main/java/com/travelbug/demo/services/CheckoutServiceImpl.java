package com.travelbug.demo.services;


import com.travelbug.demo.dao.CartRepository;
import com.travelbug.demo.dao.CustomerRepository;
import com.travelbug.demo.entities.Cart;
import com.travelbug.demo.entities.CartItem;
import com.travelbug.demo.entities.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CartRepository cartRepository;

    public CheckoutServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Transactional
    @Override
    public PurchaseResponse checkoutCart(Purchase purchase) {
        Cart cart = purchase.getCart();

        String orderTrackingNumber = generateOrderTrackingNumber();

        cart.setOrderTrackingNumber(orderTrackingNumber);

        Set<CartItem> cartItems = purchase.getCartItems();

        cartItems.forEach(cartItem -> cart.add(cartItem));

        cart.setCustomer(purchase.getCustomer());

        cartRepository.save(cart);

        return new PurchaseResponse(orderTrackingNumber);
















    }

    private String generateOrderTrackingNumber() {

        return UUID.randomUUID().toString();
    }
}
