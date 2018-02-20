package factory;

import factory.BulkCargoDoorFactory;
import factory.CrewDoorFactory;
import org.junit.Assert;
import org.junit.Test;

public class CrewDoorFactoryTest {

    @Test
    public void build() {
        Assert.assertNotNull(CrewDoorFactory.build());
    }
}
