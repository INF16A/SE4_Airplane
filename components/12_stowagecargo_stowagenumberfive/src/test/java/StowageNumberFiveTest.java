import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by felixbertsch on 30.01.18.
 */
public class StowageNumberFiveTest {

    private  ArrayList<Baggage> baggages = new ArrayList<Baggage>();
    private double expectedWeight = 0;
    @Before
    public void init(){
        Baggage baggage;

        for (int i = 0; i < 20 ; i++) {
            int random = new Random().nextInt(50);
            baggage = new Baggage("1", random, BaggageType.Bulky);
            expectedWeight += random;
            baggages.add(baggage);
        }
    }
    @Test
    public void loadBaggageTest(){
        StowageNumberFive init = new StowageNumberFive( 20);
        double BaggageWeight = init.loadBaggage(baggages);

        Assert.assertEquals(expectedWeight, BaggageWeight, 0);
    }
}
