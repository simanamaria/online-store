package com.coherentsolutions.consoleApp.main;

import com.coherentsolutions.consoleApp.XML.Comparator;
import com.coherentsolutions.consoleApp.XML.XMLParser;
import com.coherentsolutions.store.Store;
import com.coherentsolutions.store.StoreHelper;


import java.util.*;

public class StoreApp {
    public static void main(String[] args){
        Store onlineStore = new Store();
        StoreHelper storeHelper = new StoreHelper(onlineStore);
        storeHelper.populateStore();

        Scanner scanner = new Scanner(System.in);
        XMLParser xmlParserObject = new XMLParser();
        Map<String, String> parserMap = xmlParserObject.getMap();
        Comparator comparator = new Comparator();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter sort / stop / top ");
        while (scanner.hasNext()) {
            String next = scanner.next();
            if (next.equalsIgnoreCase("stop")) {
                break;
            }
            if (next.equalsIgnoreCase("sort")) {
                System.out.print("Choose sort option: ");
                parserMap.keySet().forEach((key) -> {
                    System.out.print(key);
                });
                String productListField = sc.next();
                System.out.println(comparator.productsToSort(productListField, onlineStore, parserMap));
            }
            if (next.equalsIgnoreCase("top")) {
                Map<String, String> highestPrices = new HashMap<>();
                highestPrices.put("price", "desc");
                System.out.println(comparator.mostExpensive("price", onlineStore, highestPrices));
            }}
    }
}
