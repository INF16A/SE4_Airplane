import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DroopNoseTest {
    private IDroopNose port;

    @Before
    public void testSetup() {
        port = DroopNose.getInstance().port;
    }

    @Test
    public void testFullDown() {
        port.neutral();
        int moved = port.fullDown();
        assertEquals(45, moved);
    }

    @Test
    public void testUp() {
        port.neutral();
        int degrees = port.up(10);
        assertEquals(10, degrees);
    }

    @Test
    public void testDown() {
        port.neutral();
        int degrees = port.down(10);
        assertEquals(-10, degrees);
    }
}