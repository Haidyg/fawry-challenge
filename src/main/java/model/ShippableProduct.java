package model;

import Service.ShippableService;

public class ShippableProduct extends Product implements ShippableService {
    private final double weight;
    public ShippableProduct(String id,String name,int availableQuantity, double price, double weight) {
        super(id,name,availableQuantity, price);
        this.weight=weight;
    }

    @Override
    public boolean isShippable() {
        return true;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }
}
