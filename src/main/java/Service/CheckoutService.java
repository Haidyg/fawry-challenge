package Service;

import Repo.ECommerceRepository;
import model.Cart;
import model.Checkout;
import model.Customer;

import java.util.List;

public interface CheckoutService extends ECommerceRepository<Checkout> {
    void checkout(Customer customer,List<Cart> cartList);
}
