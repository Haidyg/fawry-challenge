package model;

import java.time.LocalDate;

public class ExpirableProduct extends Product{
    private LocalDate expirationDate;
    public ExpirableProduct(String id, String name, LocalDate expirationDate, int availableQuantity, double price) {
        super(id, name, availableQuantity, price);
        this.expirationDate = expirationDate;
    }
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    // Override the isExpired method for expirable products
    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expirationDate);
    }

    @Override
    public String toString() {
        return "ExpirableProduct{id='" + getId() + "', name='" + getName() + "', expirationDate=" + expirationDate + "}";
    }

}
