import factory.APUFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class APUTest {

    private Object componentPort;


    @Test
    public void build() {
        componentPort = APUFactory.build();
        assertNotNull(componentPort);
    }

}
