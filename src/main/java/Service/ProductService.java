package Service;

import Repo.ECommerceRepository;
import model.Product;

import java.util.Date;

public interface ProductService extends ECommerceRepository<Product> {
    void ProductExpirable(boolean productExpirable);
     void QuantityAvailabilty(int quantity);
}
