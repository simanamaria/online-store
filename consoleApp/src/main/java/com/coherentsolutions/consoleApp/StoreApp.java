package com.coherentsolutions.consoleApp;

import com.coherentsolutions.consoleApp.XML.XMLParser;
import com.coherentsolutions.store.Store;
import com.coherentsolutions.store.StoreHelper;

import java.util.Map;
import java.util.Scanner;

public class StoreApp {
    public static void main(String[] args) {
        Store onlineStore = new Store();
        StoreHelper storeHelper = new StoreHelper(onlineStore);
        storeHelper.populateStore();

        Scanner scanner = new Scanner(System.in);
        XMLParser xmlParser = new XMLParser();
        Map<String, String> map = xmlParser.getMap();
        while (scanner.hasNext()) {
            String next = scanner.next();
            if (next.equalsIgnoreCase("stop")) {
                break;
            }
            if (next.equalsIgnoreCase("sort")) {
                System.out.print("Choose sort option: ");
                map.keySet().forEach((key) -> {
                    System.out.print(key);
                });
            }
        }
    }
}
