package model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

public class Product {
    private String id;
    private String name;
    private int availableQuantity;
    private double price;
    private double weight;

    public Product(String id, String name, int availableQuantity, double price, double weight) {
        this.id = id;
        this.name = name;
        this.availableQuantity = availableQuantity;
        this.price = price;
        this.weight = weight;
    }

   public Product(String id, String name, int availableQuantity, double price) {
        this.id = id;
        this.name = name;
        this.availableQuantity = availableQuantity;
        this.price = price;
    }

    public Product(String name, int availableQuantity) {
        this.name = name;
        this.availableQuantity = availableQuantity;
    }
    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public double getPrice() {
        return price;
    }

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }



    public double getWeight() {
        return weight;
    }
    public boolean isShippable(){
        return weight>0;
    }

    public String getName() {
        return name;
    }

    // Default implementation for products that do not expire
    public boolean isExpired() {
        return false;
    }
    //Default implementation for products that do not ship

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", availableQuantity=" + availableQuantity +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }
}
    /*private String name;
    private double price;
    private boolean shipable;
    private boolean canExpire;
    private String id;

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Product{id='" + id + "', name='" + name + "'}";
    }


    private Optional<LocalDate> expirationDate;

    public Product(String name) {
        this.name = name;
        this.expirationDate = Optional.empty();
    }
    public Product(String name, LocalDate expirationDate) {
        this.name = name;
        this.expirationDate = Optional.of(expirationDate);
    }
    public boolean ProductExpirable() {
        return expirationDate.isPresent();
    }
    public boolean isExpired() {
        return expirationDate.map(date -> date.isBefore(LocalDate.now())).orElse(false);
    }


    public void setName(String name) {
        this.name = name;
    }

    public Optional<LocalDate> getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Optional<LocalDate> expirationDate) {
        this.expirationDate = expirationDate;
    }
*/
