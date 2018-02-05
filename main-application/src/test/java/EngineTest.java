import factory.EngineFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class EngineTest {

    private Object componentPort;


    @Test
    public void build() {
        componentPort = EngineFactory.build();
        assertNotNull(componentPort);
    }

}
