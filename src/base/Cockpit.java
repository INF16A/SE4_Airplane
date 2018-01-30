// please do not modify

package base;

import logging.LogEngine;

public class Cockpit implements ICockpit {
    private Airplane airplane;

    public Cockpit(Airplane airplane) {
        this.airplane = airplane;
    }

    public void startup() {
        System.out.println("--- startup");
        LogEngine.instance.write("*** Cockpit.startup ***");
        airplane.startup();
        LogEngine.instance.write("");
    }

    public void taxi() {
        System.out.println("--- taxi");
        LogEngine.instance.write("*** Cockpit.taxi ***");
        airplane.taxi();
        LogEngine.instance.write("");
    }

    public void takeoff() {
        System.out.println("--- takeoff");
        LogEngine.instance.write("*** Cockpit.takeoff ***");
        airplane.takeoff();
        LogEngine.instance.write("");
    }

    public void climbing() {
        System.out.println("--- climbing");
        LogEngine.instance.write("*** Cockpit.climbing ***");
        airplane.climbing();
        LogEngine.instance.write("");
    }

    public void rightTurn() {
        System.out.println("--- rightTurn");
        LogEngine.instance.write("*** Cockpit.rightTurn ***");
        airplane.rightTurn();
        LogEngine.instance.write("");
    }

    public void leftTurn() {
        System.out.println("--- leftTurn");
        LogEngine.instance.write("*** Cockpit.leftTurn ***");
        airplane.leftTurn();
        LogEngine.instance.write("");
    }

    public void descent() {
        System.out.println("--- descent");
        LogEngine.instance.write("*** Cockpit.descent ***");
        airplane.descent();
        LogEngine.instance.write("");
    }

    public void landing() {
        System.out.println("--- landing");
        LogEngine.instance.write("*** Cockpit.landing ***");
        airplane.landing();
        LogEngine.instance.write("");
    }

    public void shutdown() {
        System.out.println("--- shutdown");
        LogEngine.instance.write("*** Cockpit.shutdown ***");
        airplane.shutdown();
        LogEngine.instance.write("");
    }

    public void startSimulation() {
        startup();
        taxi();
        takeoff();
        climbing();
        rightTurn();
        leftTurn();
        descent();
        landing();
        shutdown();
    }
}