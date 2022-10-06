package com.coherentsolutions.domain;
public class Product {
   private String name;
   private String rate;
   private String price;

    public Product(String name, String rate, String price) {
        this.name = name;
        this.rate = rate;
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
    
    @Override
    public String toString() {
        return name + " rate= " + rate + " price= " + price;
    }
}
