import factory.TaxiLightFactory;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * Created by Endrit Callaki on 30.01.2018.
 */
public class TaxiLightTest {
    private Object componentPort;

    @Test
    public void build() {
        componentPort = TaxiLightFactory.build();
        assertNotNull(componentPort);
    }

    @Test
    public void testVersion() {
        componentPort = TaxiLightFactory.build();
        try {
            Method method = componentPort.getClass().getDeclaredMethod("version");
            String version = (String) method.invoke(componentPort);
            assertEquals("TaxiLight", version);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void testOn() {
        componentPort = TaxiLightFactory.build();
        try {
            Method method = componentPort.getClass().getDeclaredMethod("on");
            boolean on = (boolean) method.invoke(componentPort);
            assertTrue(on);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void testoff() {
        componentPort = TaxiLightFactory.build();
        try {
            Method method = componentPort.getClass().getDeclaredMethod("off");
            boolean off = (boolean) method.invoke(componentPort);
            assertFalse(off);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
