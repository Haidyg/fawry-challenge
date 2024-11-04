package Imp;

import Service.CartService;
import model.Cart;
import model.Product;
import java.util.ArrayList;
import java.util.List;


public class CartServiceImp implements CartService {
    private final List<Cart> cartList = new ArrayList<>();

    @Override
    public void addToCart(Product product, int quantity) {
        if (product.getAvailableQuantity() == 0){
            System.out.printf("[WARNING] - Item %s is Out Of Stock .%n", product.getName());
            return;
        }
        if (product.isExpired()){
            System.out.printf("[WARNING] - Product %s is expired%n", product.getName());
            return;
        }
        if (quantity <= product.getAvailableQuantity()) {
            // Assuming Cart holds the Product and quantity
            Cart cartItem = new Cart(product, quantity);
            add(cartItem);
            System.out.println(quantity + " units of " + product.getName() + " added to cart.");
        } else {
            System.out.printf("[WARNING] - Requested quantity exceeds available quantity for item %s.%n", product.getName());
        }

    }

    @Override
    public void add(Cart entity) {
        cartList.add(entity);
    }

    @Override
    public List<Cart> getAll() {
        return cartList;
    }

}
