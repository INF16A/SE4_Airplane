package factory;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class RudderFactoryTest {

    @Test
    public void testBuild(){
        assertNotNull(RudderFactory.build("1","test","3"));
    }
}
