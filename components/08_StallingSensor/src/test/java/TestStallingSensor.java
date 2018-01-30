import static org.junit.Assert.*;
import org.junit.Test;

public class TestStallingSensor extends StallingSensor{

    @Test
    public void testAlertIsNotAlerted(){
        StallingSensor testSensor = new StallingSensor();
        assertFalse(testSensor.alarm());
    }
}
