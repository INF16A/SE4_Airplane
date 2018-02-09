package factory;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class SpoilerFactoryTest {
    @Test
    public void testBuild(){
        assertNotNull(SpoilerFactory.build("1","test","3"));
    }
}
