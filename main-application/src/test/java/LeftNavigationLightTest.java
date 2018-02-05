import factory.LeftNavigationLightFactory;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * Created by Endrit Callaki on 30.01.2018.
 */
public class LeftNavigationLightTest {

    private Object componentPort;


    @Test
    public void build() {
        componentPort = LeftNavigationLightFactory.build();
        assertNotNull(componentPort);
    }

    @Test
    public void testVersion() {
        componentPort = LeftNavigationLightFactory.build();
        try {
            Method method = componentPort.getClass().getDeclaredMethod("version");
            String version = (String) method.invoke(componentPort);
            assertEquals("LeftNavigationLight", version);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void testOn() {
        componentPort = LeftNavigationLightFactory.build();
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
        componentPort = LeftNavigationLightFactory.build();
        try {
            Method method = componentPort.getClass().getDeclaredMethod("off");
            boolean off = (boolean) method.invoke(componentPort);
            assertFalse(off);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void testSetLightType() {
        componentPort = LeftNavigationLightFactory.build();
        try {
            Method method = componentPort.getClass().getDeclaredMethod("setLightType", String.class);
            Enum type = (Enum) method.invoke(componentPort, new Object[]{LightType.red.toString()});
            Assert.assertEquals(LightType.red, type);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void testSetPosition() {
        componentPort = LeftNavigationLightFactory.build();
        try {
            Method method = componentPort.getClass().getDeclaredMethod("setPosition", String.class);
            Enum type = (Enum) method.invoke(componentPort, new Object[]{Position.port.toString()});
            Assert.assertEquals(Position.port, type);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}
