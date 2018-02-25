package factory;

import factory.EmergencyExitDoorFactory;
import org.junit.Assert;
import org.junit.Test;

public class EmergencyExitDoorFactoryTest {

    @Test
    public void build() {
        Assert.assertNotNull(EmergencyExitDoorFactory.build());
    }

}
