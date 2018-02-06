package factory;

import org.junit.Assert;
import org.junit.Test;

public class EngineOilTankFactoryTest {
    @Test
    public void build() {
        Assert.assertNotNull(EngineOilTankFactory.build());

    }
}
