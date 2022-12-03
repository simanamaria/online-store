package com.coherentsolutions.consoleApp.storeHandler;

import java.util.Timer;

public class Stop extends AbstractHandler{
    public Stop() {
        super(new Top5());
    }

    @Override
    public void handleRequest(String input) throws Exception {
        if (input.equals("stop")){
            Timer timer = new Timer();
            timer.cancel();
        } else if (getNext() != null) {
            getNext().handleRequest(input);
        }
    }
}
