package com.coherentsolutions.consoleApp.XML;

import com.coherentsolutions.domain.Category;
import com.coherentsolutions.domain.Product;
import com.coherentsolutions.store.Store;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Comparator {
    public List<Product> productsToSort(String field, Store onlineStore, Map<String, String> map) {
        List<Product> products = onlineStore.getCategoryList().stream().map(Category::getProductList).flatMap(Collection::stream).collect(Collectors.toList());
        String s = map.get(field);
        try {
            if (s.equalsIgnoreCase("asc")) {
                if (field.equals("name")) {
                    products.sort(java.util.Comparator.comparing(Product::getName));
                }
                if (field.equals("price")) {
                    products.sort(java.util.Comparator.comparing(Product::getPrice));
                }
                if (field.equals("rate")) {
                    products.sort(java.util.Comparator.comparing(Product::getRate));
                }
            }
            if (s.equalsIgnoreCase("desc")) {
                if (field.equals("name")) {
                    products.sort(java.util.Comparator.comparing(Product::getName).reversed());
                }
                if (field.equals("price")) {
                    products.sort(java.util.Comparator.comparing(Product::getPrice).reversed());
                }
                if (field.equals("rate")) {
                    products.sort(java.util.Comparator.comparing(Product::getRate).reversed());
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Choose between name price and rate");
        }
        return products;
    }

    public List<Product> mostExpensive(String field, Store onlineStore, Map<String, String> map) {
        return productsToSort(field, onlineStore, map).subList(0, 5);
    }}
