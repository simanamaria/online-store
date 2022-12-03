package com.coherentsolutions.consoleApp.storeHandler;

import com.coherentsolutions.consoleApp.XML.ProductComparator;
import com.coherentsolutions.store.Store;

public class SortProducts extends AbstractHandler {


    public SortProducts() {
        super(new Stop());
    }

    @Override
    public void handleRequest(String input) throws Exception {
        if (input.equals("sort")){
            ProductComparator comparator = new ProductComparator();
            Store onlineStore = Store.getInstance();
             comparator.sortProducts(onlineStore);
        } else if (getNext() != null) {
            getNext().handleRequest(input);
        }
    }
}
