package com.coherentsolutions.domain;
public class Product {
   private String name;
   private double rate;
   private double price;

    public Product(String name, double rate, double price) {
        this.name = name;
        this.rate = rate;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public void setRate(double rate) {
        this.rate = rate;
    }
    
    @Override
    public String toString() {
        return name + " rate= " + rate + " price= " + price;
    }
}
