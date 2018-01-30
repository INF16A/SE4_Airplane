package test;

import base.Airplane;
import base.Cockpit;
import logging.LogEngine;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProcedureTest {
    private Airplane airplane;
    private Cockpit cockpit;

    @Before
    public void init() {
        LogEngine.instance.init();

        airplane = new Airplane();
        airplane.build();

        cockpit = new Cockpit(airplane);
    }

    @Test
    public void setup() {
    }

    @Test
    public void startUp() {
        cockpit.startup();
    }

    @Test
    public void taxi() {
        cockpit.taxi();
    }

    @Test
    public void takeOff() {
        cockpit.takeoff();
    }

    @Test
    public void climbing() {
        cockpit.climbing();
    }

    @Test
    public void rightTurn() {
        cockpit.rightTurn();
    }

    @Test
    public void leftTurn() {
        cockpit.leftTurn();
    }

    @Test
    public void descent() {
        cockpit.descent();
    }

    @Test
    public void landing() {
        cockpit.landing();
    }

    @Test
    public void shutdown() {
        cockpit.shutdown();
    }

    @After
    public void logEngineClose() {
        LogEngine.instance.close();
    }
}