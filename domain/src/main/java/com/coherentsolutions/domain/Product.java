package com.coherentsolutions.domain;
public class Product {
   private String name;
   private int rate;
   private int price;

    public Product(String name, int rate, int price) {
        this.name = name;
        this.rate = rate;
        this.price = price;
    }



    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
    
    @Override
    public String toString() {
        return name + " rate= " + rate + " price= " + price;
    }
}
