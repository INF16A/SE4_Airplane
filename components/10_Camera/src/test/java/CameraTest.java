import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CameraTest {

    private Camera cam;

    private final double DELTA = 1e-15;

    @Before
    public void init(){
        cam = new Camera();
    }

    @Test
    public void testVersion(){
        assertEquals("Camera 23" , cam.version());
    }

    @Test
    public void testSetType(){
        assertEquals(CameraType.tail, cam.setType("tail"));
    }

    @Test
    public void testOn(){
        assertTrue(cam.on());
    }

    @Test
    public void testRecord(){
        assertEquals("Camera EADS", cam.record());
    }

    @Test
    public void testZoomIn(){
        assertEquals(2.0, cam.zoomIn(false), this.DELTA);
        assertEquals(2.0, cam.zoomIn(true), this.DELTA);
    }

    @Test
    public void testOff(){
        assertFalse(cam.off());
    }
}
