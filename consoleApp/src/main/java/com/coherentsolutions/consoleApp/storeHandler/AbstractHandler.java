package com.coherentsolutions.consoleApp.storeHandler;

public abstract class AbstractHandler implements Handler{
    private AbstractHandler next;

    public AbstractHandler(AbstractHandler next) {
        this.next = next;
    }

    public AbstractHandler getNext() {
        return next;
    }

    public abstract void handleRequest(String input) throws Exception;
}
