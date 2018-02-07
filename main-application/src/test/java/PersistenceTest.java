import org.junit.Test;
import recorder.FlightRecorder;

public class PersistenceTest {
    @Test
    public void FlightRecorderTest() {
        FlightRecorder.instance.startup();
        FlightRecorder.instance.createTable();
        FlightRecorder.instance.insert("Test","Test");
        FlightRecorder.instance.shutdown();
    }

}
