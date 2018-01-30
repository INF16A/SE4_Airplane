package section;

import java.util.ArrayList;

import logging.LogEngine;
import event.Subscriber;

public class Body extends Subscriber {
    private ArrayList<Object> weatherRadarPorts;

    public Body() {
        weatherRadarPorts = new ArrayList<>();
        build();
        printStatus();
    }

    public void build() {
        // please add here
    }

    public void printStatus() {
        try {
            LogEngine.instance.write("--- Body ---");

            // please add here

            LogEngine.instance.write("");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // please add here
}