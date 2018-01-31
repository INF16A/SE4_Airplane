import factory.APUFactory;
import factory.CameraFactory;
import factory.EngineFactory;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class EngineTest {

    private Object componentPort;


    @Test
    public void build() {
        componentPort = EngineFactory.build();
        assertNotNull(componentPort);
    }

}
