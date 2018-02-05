import factory.TCASLightFactory;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * Created by Endrit Callaki on 30.01.2018.
 */
public class TCASLightTest {
    private Object componentPort;

    @Test
    public void build() {
        componentPort = TCASLightFactory.build();
        assertNotNull(componentPort);
    }

    @Test
    public void testVersion() {
        componentPort = TCASLightFactory.build();
        try {
            Method method = componentPort.getClass().getDeclaredMethod("version");
            String version = (String) method.invoke(componentPort);
            assertEquals("TCASLight", version);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testOn() {
        componentPort = TCASLightFactory.build();
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
        componentPort = TCASLightFactory.build();
        try {
            Method method = componentPort.getClass().getDeclaredMethod("off");
            String off = (String) method.invoke(componentPort);
            assertEquals("TCASLight is off.", off);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
