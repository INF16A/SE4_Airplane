package factory;

import org.junit.Assert;
import org.junit.Test;

public class PotableWaterTankFactoryTest {
    @Test
    public void build() {
        Assert.assertNotNull(PotableWaterTankFactory.build());
    }
}
