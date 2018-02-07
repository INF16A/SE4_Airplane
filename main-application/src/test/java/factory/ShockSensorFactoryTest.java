package factory;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ShockSensorFactoryTest {

    @Test
    public void testBuild(){
        assertNotNull(ShockSensorFactory.build());
    }
}
