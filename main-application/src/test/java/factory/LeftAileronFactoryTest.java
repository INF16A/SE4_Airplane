package factory;

import static org.junit.Assert.*;
import org.junit.Test;


public class LeftAileronFactoryTest {

    @Test
    public void testBuild(){
        assertNotNull(LeftAileronFactory.build("1","test","3"));
    }


}
