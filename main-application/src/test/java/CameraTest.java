import factory.CameraFactory;
import javafx.scene.Camera;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Method;

public class CameraTest {

    private Object componentPort;

    private enum CameraType{
        tail,
        wing,
        taxi
    };

    private final double DELTA = 1e-15;

    @Test
    public void build() {
        componentPort = CameraFactory.build();
        assertNotNull(componentPort);
    }

    @Test
    public void testVersion(){
        componentPort = CameraFactory.build();

        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("version");
            String version = (String)onMethod.invoke(componentPort);
            assertEquals("Camera 23" , version);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testSetType(){
        componentPort = CameraFactory.build();

        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("setType");
            Enum type = (Enum)onMethod.invoke(componentPort, new Object[]{CameraType.tail.toString()});
            assertEquals(CameraType.tail, type);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testOn(){
        componentPort = CameraFactory.build();

        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("on");
            boolean on = (boolean)onMethod.invoke(componentPort);
            assertTrue(on);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testRecord(){
        componentPort = CameraFactory.build();

        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("on");
            String record = (String)onMethod.invoke(componentPort);
            assertEquals("Camera EADS", record);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testZoomIn(){
        componentPort = CameraFactory.build();

        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("zoomIn");
            double zoom = (double)onMethod.invoke(componentPort, new Object[]{false});
            assertEquals(2.0, zoom, this.DELTA);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testOff(){
        componentPort = CameraFactory.build();

        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("off");
            boolean off = (boolean)onMethod.invoke(componentPort);
            assertFalse(off);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
