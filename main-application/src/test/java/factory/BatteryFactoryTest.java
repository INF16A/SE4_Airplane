package factory;

import org.junit.Assert;
import org.junit.Test;

public class BatteryFactoryTest {
    @Test
    public void build() {
        Assert.assertNotNull(BatteryFactory.build());

    }
}
