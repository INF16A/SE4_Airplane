import factory.AntiCollisionLightFactory;
import javafx.geometry.Pos;
import javafx.scene.Camera;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.lang.reflect.Method;


public class AntiCollisionLightTest {
    private Object componentPort;

    @Test
    public void build() {
        componentPort = AntiCollisionLightFactory.build();
        assertNotNull(componentPort);
    }

    @Test
    public void testVersion() {
        componentPort = AntiCollisionLightFactory.build();
        try {
            Method method = componentPort.getClass().getDeclaredMethod("version");
            String version = (String) method.invoke(componentPort);
            assertEquals("AntiCollisionLight", version);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void testOn() {
        componentPort = AntiCollisionLightFactory.build();
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
        componentPort = AntiCollisionLightFactory.build();
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
