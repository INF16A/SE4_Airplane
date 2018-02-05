import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HydraulicPumpTest {

    private HydraulicPump.Port port;

    @Before
    public void init() {
        port = HydraulicPump.getInstance().port;
    }

    @Test
    public void version() {
        Assert.assertEquals("Hydraulic Pump 1.0", port.version());
    }

    @Test
    public void compress() {
        Assert.assertEquals(50, port.compress());
    }

    @Test
    public void compressWithNumber() {
        Assert.assertEquals(0, port.compress(1));
    }

    @Test
    public void decompress() {
        Assert.assertEquals(2000, port.decompress());
    }

    @Test
    public void refilOil() {
        Assert.assertEquals(100, port.refillOil());
    }

    @Test
    public void refilOilWithNumber() {
        Assert.assertEquals(60, port.refillOil(10));
    }


}
