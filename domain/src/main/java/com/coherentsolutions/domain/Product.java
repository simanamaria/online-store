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

    public String getName() {
        return name;
    }

    public int getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return '\n' + "Product " +
                "name='" + name + '\'' +
                ", price=" + price +
                ", rate=" + rate;
    }

}
