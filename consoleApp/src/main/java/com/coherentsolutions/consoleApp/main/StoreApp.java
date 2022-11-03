package com.coherentsolutions.consoleApp.main;

import com.coherentsolutions.consoleApp.XML.ProductComparator;
import com.coherentsolutions.consoleApp.XML.XMLParser;
import com.coherentsolutions.store.Store;
import com.coherentsolutions.store.StoreHelper;


import java.util.*;

public class StoreApp {
    public static void main(String[] args) throws Exception {
        Store onlineStore = new Store();
        StoreHelper storeHelper = new StoreHelper(onlineStore);
        storeHelper.populateStore();

        Scanner scanner = new Scanner(System.in);
        ProductComparator comparator = new ProductComparator();

        System.out.println("Please enter sort / stop / top ");
        while (scanner.hasNext()) {
            String next = scanner.next();
            if (next.equalsIgnoreCase("stop")) {
                break;
            }
            if (next.equalsIgnoreCase("sort")) {
                comparator.sortProducts(onlineStore);
            }
            if (next.equalsIgnoreCase("top")) {
                comparator.mostExpensive(onlineStore);
            }}
    }
}
