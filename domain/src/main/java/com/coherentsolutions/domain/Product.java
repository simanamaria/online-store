package com.coherentsolutions.domain;

import javax.persistence.*;

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   private String name;
   private int rate;
   private int price;
   @OneToMany (cascade = CascadeType.ALL)
   @JoinColumn(name = "category_id", referencedColumnName = "product_id")
   private CategoryFactory categoryFactory;
    public Product(String name, int rate, int price) {
        this.name = name;
        this.rate = rate;
        this.price = price;
    }

    public Product() {
    }

    public Product(int id, String name, int rate, int price) {
        this.id = id;
        this.name = name;
        this.rate = rate;
        this.price = price;
    }

    public Product(int numberBetween, String productName, int numberBetween1, int numberBetween2, String emailAddress) {
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getRate() {
        return rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return '\n' + "Product " +
                "name='" + name + '\'' +
                ", price=" + price +
                ", rate=" + rate;
    }

}
