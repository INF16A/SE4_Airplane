package factory;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class RightAileronFactoryTest {

    @Test
    public void testBuild(){
        assertNotNull(RightAileronFactory.build("1","test","3"));
    }
}
