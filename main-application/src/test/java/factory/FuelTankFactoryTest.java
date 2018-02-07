package factory;

import org.junit.Assert;
import org.junit.Test;

public class FuelTankFactoryTest {
    @Test
    public void build() {
        Assert.assertNotNull(FuelTankFactory.build());

    }
}
