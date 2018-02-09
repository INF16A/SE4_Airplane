import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ElevatorTest {
    private IElevator port;

    @Before
    public void testSetup() {
        port = Elevator.getInstance().port;
    }

    @Test
    public void testFullUp() {
        port.neutral();
        int moved = port.fullUp();
        assertEquals(45, moved);
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
