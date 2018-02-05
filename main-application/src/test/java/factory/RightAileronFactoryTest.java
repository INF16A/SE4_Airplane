package factory;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class RightAileronFactoryTest {

    @Test
    public void testBuild(){
        assertNotNull(RightAileronFactory.build("1","test","3"));
    }
}
