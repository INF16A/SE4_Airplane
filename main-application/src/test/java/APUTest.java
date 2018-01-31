import factory.APUFactory;
import factory.CameraFactory;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class APUTest {

    private Object componentPort;


    @Test
    public void build() {
        componentPort = APUFactory.build();
        assertNotNull(componentPort);
    }

}
