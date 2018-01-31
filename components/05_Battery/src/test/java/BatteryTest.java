

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BatteryTest {
    private Battery.Port port;

    @Before
    public void init(){
        port = Battery.getInstance().port;
    }

    @Test
    public void version(){
        Assert.assertEquals("v1.0", port.version());
    }

    @Test
    public void charge() {
        boolean asser = false;
        int val1 = port.charge();
        int val2 = port.charge();
        if ((val1 == 100 && val2 == 100) || val2-val1==1) {
            asser = true;
        }
        Assert.assertTrue(asser);
    }

    @Test
    public void discharge() {
        boolean asser = false;
        int val1 = port.discharge();
        int val2 = port.discharge();
        if ((val1 == 0 && val2 == 0) || val1-val2==1) {
            asser = true;
        }
        Assert.assertTrue(asser);
    }
}