package com.coherentsolutions.consoleApp.storeHandler;

import com.coherentsolutions.consoleApp.XML.ProductComparator;
import com.coherentsolutions.store.Store;

public class Top5 extends AbstractHandler{
    public Top5() {
        super(new OrderFromCart());
    }

    @Override
    public void handleRequest(String input) throws Exception {
        if (input.equals("top")){
            ProductComparator comparator = new ProductComparator();
            Store onlineStore = Store.getInstance();
            comparator.mostExpensive(onlineStore);
        } else if (getNext() != null) {
            getNext().handleRequest(input);
        }
    }
}
