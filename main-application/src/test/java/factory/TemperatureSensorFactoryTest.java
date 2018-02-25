package factory;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class TemperatureSensorFactoryTest {

    @Test
    public void testBuild(){
        assertNotNull(TemperatureSensorFactory.build());
    }
}
