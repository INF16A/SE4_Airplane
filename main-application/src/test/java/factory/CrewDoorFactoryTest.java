package factory;

import org.junit.Assert;
import org.junit.Test;

public class CrewDoorFactoryTest {

    @Test
    public void build() {
        Assert.assertNotNull(CrewDoorFactory.build());
    }
}
