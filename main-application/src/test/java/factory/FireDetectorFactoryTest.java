package factory;

import org.junit.Test;
import static org.junit.Assert.*;

public class FireDetectorFactoryTest {

    @Test
    public void testBuild(){
        assertNotNull(FireDetectorFactory.build());
    }
}
