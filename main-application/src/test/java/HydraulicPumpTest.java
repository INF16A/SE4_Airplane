import factory.HydraulicPumpFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class HydraulicPumpTest {

    private Object componentPort;


    @Test
    public void build() {
        componentPort = HydraulicPumpFactory.build();
        assertNotNull(componentPort);
    }

}
