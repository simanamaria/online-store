package com.coherentsolutions.consoleApp;

import com.coherentsolutions.consoleApp.XML.XMLParser;
import com.coherentsolutions.store.Store;
import com.coherentsolutions.store.StoreHelper;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StoreApp {
    public static void main(String[] args) {
        Store onlineStore = new Store();
        StoreHelper storeHelper = new StoreHelper(onlineStore);
        storeHelper.populateStore();

        Scanner scanner = new Scanner(System.in);
        XMLParser xmlParser = new XMLParser();
        Map<String, String> parserMap = xmlParser.getMap();
        Comparator comparator = (Comparator) new com.coherentsolutions.consoleApp.XML.Comparator();
        System.out.println("Please enter sort/ stop ");
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

                String sortByField = scanner.next();
                System.out.println(comparator.sortedProductList(sortByField, store, parserMap));
            }
            if (next.equalsIgnoreCase("top")) {
                Map<String, String> topPrices = new HashMap<>();
                topPrices.put("price", "desc");
                System.out.println(comparator.mostExpensive("price", store, topPrices));
            }
            }
        }
    }
}
