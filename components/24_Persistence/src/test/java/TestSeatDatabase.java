import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TestSeatDatabase {
    SeatDatabase database;

    @Before
    public void init() {
        database = SeatDatabase.getInstance();
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
    public void isSeatDatabaseEmpty(){
        List<String> output = new ArrayList<>();
        database.startup();
        database.dropTable();
        database.createTable();
        database.importCSVDataSeats(Configuration.instance.seatsArchive);
        output = database.getSeats();
        database.shutdown();
        System.out.println(output.toString());
        assertNotNull(output);

    }

}
