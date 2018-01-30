import factory.VHFFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import factory.StowageNumberFiveFactory;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by felixbertsch on 30.01.18.
 */
public class StowageNumberFiveTest {
    private Object componentPort;
    private ArrayList<Baggage> baggages = new ArrayList<Baggage>();
    private double expectedWeight = 0;
    /*
    @Before
    public void init() {
        Baggage baggage;

        for (int i = 0; i < 20; i++) {
            int random = new Random().nextInt(50);
            baggage = new Baggage("1", random, BaggageType.Bulky);
            expectedWeight += random;
            baggages.add(baggage);
        }
    }

    @Test
    public void build() {
        componentPort = StowageNumberFiveFactory.build();
        Assert.assertNotNull(componentPort);
    }

    @Test
    public void loadBaggageTest() {
        componentPort = StowageNumberFiveFactory.build();
        try {
            Method loadBaggage = componentPort.getClass().getDeclaredMethod("loadBaggage", ArrayList.class);
            double receiveResult = (double)loadBaggage.invoke(componentPort);
            Assert.assertEquals(expectedWeight, receiveResult, 0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}