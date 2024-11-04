package Imp;

import Service.CheckoutService;
import model.Cart;
import model.Checkout;
import model.Customer;
import model.Product;

import java.util.List;

public class CheckoutServiceImp implements CheckoutService {

    @Override
    public void add(Checkout entity) {

    }

    @Override
    public List<Checkout> getAll() {
        return null;
    }

    @Override
    public void checkout(Customer customer, List<Cart> cartList) {
        if (cartList.isEmpty()){
            System.out.println("[ERROR] - No cart to checkout");
            return;
        }
        double subtotal = 0;
        double shippingFees = 0;
        double totalWeight = 0;

        StringBuilder shipmentNotice = new StringBuilder();
        StringBuilder checkoutReceipt = new StringBuilder();

        // Generate Shipment Notice
        shipmentNotice.append("** Shipment notice **\n");
        for (Cart cart : cartList) {
            Product product = cart.getProduct();
            int quantity = cart.getQuantity();
            double totalPrice = product.getPrice() * quantity;

            // Calculate subtotal
            subtotal += totalPrice;

            // Add product details to checkout receipt
            checkoutReceipt.append(quantity).append("x ")
                    .append(product.getName()).append(" ")
                    .append(totalPrice).append("\n");

            // Add to shipment notice if product is shippable
            if (product.isShippable()) {
                double productWeight = product.getWeight() * quantity;
                totalWeight += productWeight;
                shipmentNotice.append(quantity).append("x ")
                        .append(product.getName()).append(" ")
                        .append(productWeight).append("grams\n");

                // Add example shipping fee calculation
                shippingFees += 10 * quantity;
            }
        }

        shipmentNotice.append("Total package weight ").append(totalWeight).append("grams\n");

        // Calculate total amount
        double totalAmount = subtotal + shippingFees;


        if (customer.getBalance() >= totalAmount) {
            customer.deductBalance(totalAmount);

            // Print checkout details
            System.out.println(shipmentNotice);
            System.out.println("** Checkout receipt **");
            System.out.print(checkoutReceipt);
            System.out.println("----------------------");
            System.out.println("Subtotal " + subtotal);
            System.out.println("Shipping " + shippingFees);
            System.out.println("Amount " + totalAmount);
        } else {
            System.out.println("[ERROR] - Insufficient balance for checkout.");
        }
    }
}
