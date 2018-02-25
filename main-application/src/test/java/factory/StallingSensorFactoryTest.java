package factory;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class StallingSensorFactoryTest {

    @Test
    public void testBuild(){
        assertNotNull(StallingSensorFactory.build());
    }
}
