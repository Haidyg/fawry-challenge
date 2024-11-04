package model;

public class NonShippableProduct extends Product{
    public NonShippableProduct(String id, String name,int availableQuantity, double price) {
        super(id, name, availableQuantity, price );
    }

    @Override
    public boolean isShippable() {
        return false;
    }
}
