import factory.RightNavigationLightFactory;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Endrit Callaki on 30.01.2018.
 */
public class RightNavigationLightTest {
    private Object componentPort;

    @Test
    public void build() {
        componentPort = RightNavigationLightFactory.build();
        assertNotNull(componentPort);
    }

    @Test
    public void testVersion() {
        componentPort = RightNavigationLightFactory.build();
        try {
            Method method = componentPort.getClass().getDeclaredMethod("version");
            String version = (String) method.invoke(componentPort);
            assertEquals("RightNavigationLight", version);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void testOn() {
        componentPort = RightNavigationLightFactory.build();
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
        componentPort = RightNavigationLightFactory.build();
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
        componentPort = RightNavigationLightFactory.build();
        try {
            Method method = componentPort.getClass().getDeclaredMethod("setLightType", String.class);
            Enum type = (Enum) method.invoke(componentPort, new Object[]{LightType.green.toString()});
            assertEquals(LightType.green, type);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void testSetPosition() {
        componentPort = RightNavigationLightFactory.build();
        try {
            Method method = componentPort.getClass().getDeclaredMethod("setPosition", String.class);
            Enum type = (Enum) method.invoke(componentPort, new Object[]{Position.starboard.toString()});
            assertEquals(Position.starboard, type);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}
