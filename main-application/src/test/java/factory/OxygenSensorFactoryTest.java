package factory;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class OxygenSensorFactoryTest {

    @Test
    public void testBuild(){
        assertNotNull(OxygenSensorFactory.build());
    }
}
