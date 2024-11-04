package org.example;

import Imp.CartServiceImp;
import Imp.CheckoutServiceImp;
import Service.CheckoutService;
import Service.ShippableService;
import model.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        CartServiceImp cartService = new CartServiceImp();

        Product regularProduct = new Product("1", "Non-Expiring Product", 5, 3.0);
        ExpirableProduct expiringProduct = new ExpirableProduct("2", "Milk", LocalDate.now().minusDays(1), 2, 2.0);


        Product shippableProduct = new ShippableProduct("3", "Cheese",10,4.1, 4.0); // Weight in kg
        Product nonShippableProduct = new NonShippableProduct("4","ScretchCard", 1, 10.0);

        if (shippableProduct.isShippable()) {
            System.out.println(shippableProduct.getName() + " requires shipping with weight: " + ((ShippableService)shippableProduct).getWeight()+ "grams");
        } else {
            System.out.println(nonShippableProduct.getName() + " does not require shipping with weight: ");
        }
        cartService.addToCart(regularProduct, 5);  // Valid quantity
        cartService.addToCart(expiringProduct, 10); // Invalid quantity (exceeds availability)
        cartService.addToCart(shippableProduct, 7); // Valid quantity
        cartService.addToCart(nonShippableProduct, 1);


        // Create a customer
        Customer customer = new Customer("1", "Haidy", 200);

        // Add products to the cart
        Product product1 = new Product("1", "Laptop", 5, 20.0);
        Product product2 = new Product("2", "Headphones", 3, 10.0);

        cartService.addToCart(product1, 2); // Adding 2 Laptops
        cartService.addToCart(product2, 1); // Adding 1 Headphone

        var itemsInCart = cartService.getAll();

        CheckoutService checkoutService = new CheckoutServiceImp();

        System.out.println("#################################################");

        // Perform checkout
        checkoutService.checkout(customer, itemsInCart);

    }
}