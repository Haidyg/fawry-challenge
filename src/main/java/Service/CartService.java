package Service;

import Repo.ECommerceRepository;
import model.Cart;
import model.Customer;
import model.Product;

public interface CartService extends ECommerceRepository<Cart> {
    void addToCart(Product product,int quantity);
}
