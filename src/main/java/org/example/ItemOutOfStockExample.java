package org.example;

import Imp.CartServiceImp;
import Imp.CheckoutServiceImp;
import Service.CartService;
import Service.CheckoutService;
import model.Customer;
import model.ExpirableProduct;

import java.time.LocalDate;

public class ItemOutOfStockExample {
    public static void main(String[] args) {
        // Create a customer
        Customer customer = new Customer("1", "Haidy", 200);

        // Expired item example
        ExpirableProduct expiringProduct = new ExpirableProduct("2", "Milk", LocalDate.now().plusDays(3), 0, 2.0);
        CartService cartService = new CartServiceImp();

        cartService.addToCart(expiringProduct, 1);
        var itemsInCart = cartService.getAll();

        CheckoutService checkoutService = new CheckoutServiceImp();

        // Perform checkout
        checkoutService.checkout(customer, itemsInCart);
    }
}
