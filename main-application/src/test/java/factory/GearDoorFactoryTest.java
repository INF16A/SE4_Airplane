package factory;

import factory.GearDoorFactory;
import org.junit.Assert;
import org.junit.Test;

public class GearDoorFactoryTest {
    @Test
    public void build() {
        Assert.assertNotNull(GearDoorFactory.build());
    }
}
