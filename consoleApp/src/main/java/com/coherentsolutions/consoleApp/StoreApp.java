package com.coherentsolutions.consoleApp;

import com.coherentsolutions.store.Store;
import com.coherentsolutions.store.StoreHelper;

public class StoreApp {
    public static void main(String[] args) {
        Store onlineStore = new Store();
        StoreHelper storeHelper = new StoreHelper(onlineStore);
        storeHelper.populateStore();
        onlineStore.printCategoryProducts();
    }
}
