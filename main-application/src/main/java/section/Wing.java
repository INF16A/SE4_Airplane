package section;

import event.Subscriber;
import logging.LogEngine;

import java.util.ArrayList;

public class Wing extends Subscriber {
    private int wingIndex;

    private ArrayList<Object> weatherRadarPorts;

    public Wing(int wingIndex) {
        this.wingIndex = wingIndex;
        weatherRadarPorts = new ArrayList<>();
        build();
        printStatus();
    }

    public void build() {
        // please add here
    }

    public void printStatus() {
        try {
            LogEngine.instance.write(wingIndex == 0 ? "--- left Wing ---" : "--- right Wing ---");

            // please add here

            LogEngine.instance.write("");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // please add here
}