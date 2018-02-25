import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

/*
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by felixbertsch on 30.01.18.
 */
public class CargoSystemTest {


    private CargoSystem.Port cargoSystem = new CargoSystem().port;
    private Stowage stowage;
    private int expectedWeight;
    @Before
    public void init(){
        ArrayList<Container> containerList = new ArrayList<Container>();
        ArrayList<Baggage> baggages = new ArrayList<Baggage>();
        Baggage baggage;
        stowage = new Stowage(StowageType.front);
        for (int i = 0; i < 5 ; i++) {
            Container container = new Container();
            for (int j = 0; j < 5 ; j++) {
                for (int k = 0; k < 10 ; k++) {
                    int random = new Random().nextInt(50);
                    baggage = new Baggage("1", random, BaggageType.Bulky);
                    expectedWeight += random;
                    baggages.add(baggage);
                }
                container.setBaggageList(baggages);
            }
            containerList.add(container);
        }
        stowage.setContainerList(containerList);
    }
    @Test
    public void unlockTest(){
        Assert.assertTrue(cargoSystem.unlock());
    }
    @Test
    public void lockTest(){
        Assert.assertTrue(cargoSystem.lock());
    }
    @Test
    public void secureTest(){
        Assert.assertTrue(cargoSystem.secure());
}

}
