import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestFlightRecorder {
    FlightRecorder database;

    @Before
    public void init() {
        database = FlightRecorder.getInstance();
    }

    @Test
    public void isConnectionOpen() {
        try {
            database.startup();
            assertFalse(database.getConnection().isClosed());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void isConnectionClosed() {
        try {
            database.startup();
            database.shutdown();
            assertTrue(database.getConnection().isClosed());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void invokedropTableMethod(){
        database.startup();
        database.init();
        database.dropTable();
    }
}
