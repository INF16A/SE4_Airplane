package factory;

import org.junit.Assert;
import org.junit.Test;

public class APUOilTankFactoryTest {
    @Test
    public void build(){
        Assert.assertNotNull(APUOilTankFactory.build());

    }
}
