import configuration.Configuration;
import database.SeatDatabase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class SeatDatabaseTest {

    @Test
    public void SeatDatabaseTest() {
        List<String> output;
        SeatDatabase.instance.startup();
        SeatDatabase.instance.dropTable();
        SeatDatabase.instance.createTable();
        SeatDatabase.instance.init();
        output = SeatDatabase.instance.getSeats();
        SeatDatabase.instance.shutdown();
        assertNotNull(output);
        System.out.println(output.toString());
    }

}
