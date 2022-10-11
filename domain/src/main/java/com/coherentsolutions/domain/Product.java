package com.coherentsolutions.domain;
public class Product {
   private String name;
   private double rate;
   private double price;

    public Product(String name, String rate, String price) {
        this.name = name;
        this.rate = Double.parseDouble(rate);
        this.price = Double.parseDouble(price);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = Double.parseDouble(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = Double.parseDouble(rate);
    }
    
    @Override
    public String toString() {
        return name + " rate= " + rate + " price= " + price;
    }
}
