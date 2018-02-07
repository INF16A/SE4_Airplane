import factory.CameraFactory;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class CameraTest {

    private final double DELTA = 1e-15;
    private Object componentPort;

    @Test
    public void build() {
        componentPort = CameraFactory.build();
        assertNotNull(componentPort);
    }

    @Test
    public void testVersion() {
        componentPort = CameraFactory.build();

        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("version");
            String version = (String) onMethod.invoke(componentPort);
            assertEquals("Camera 23", version);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testSetType() {
        componentPort = CameraFactory.build();

        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("setType", String.class);
            Enum type = (Enum) onMethod.invoke(componentPort, new Object[]{CameraType.tail.toString()});
            assertEquals(CameraType.tail.toString(), type.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testOn() {
        componentPort = CameraFactory.build();

        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("on");
            boolean on = (boolean) onMethod.invoke(componentPort);
            assertTrue(on);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testRecord() {
        componentPort = CameraFactory.build();

        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("record");
            String record = (String) onMethod.invoke(componentPort);
            assertEquals("Camera EADS", record);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testZoomIn() {
        componentPort = CameraFactory.build();

        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("zoomIn", boolean.class);
            double zoom = (double) onMethod.invoke(componentPort, new Object[]{false});
            assertEquals(2.0, zoom, this.DELTA);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testOff() {
        componentPort = CameraFactory.build();

        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("off");
            boolean off = (boolean) onMethod.invoke(componentPort);
            assertFalse(off);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private enum CameraType {
        tail,
        wing,
        taxi
    }
}
