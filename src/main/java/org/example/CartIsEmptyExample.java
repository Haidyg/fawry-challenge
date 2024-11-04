package org.example;

import Imp.CheckoutServiceImp;
import Service.CheckoutService;
import model.Cart;
import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CartIsEmptyExample {
    public static void main(String[] args) {
        // Create a customer
        Customer customer = new Customer("1", "Haidy", 100);


        CheckoutService checkoutService = new CheckoutServiceImp();

        // Perform checkout
        checkoutService.checkout(customer, new ArrayList<>());
    }
}
