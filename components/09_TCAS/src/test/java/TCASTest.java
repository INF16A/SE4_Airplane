import org.junit.Assert;
import org.junit.Test;

public class TCASTest {

    TCAS.Port port = TCAS.getInstance().port;

    @Test
    public void on() {
        Assert.assertTrue(port.on());
    }

    @Test
    public void off() {
        Assert.assertFalse(port.off());
    }

    @Test
    public void connect() {
        Assert.assertEquals("drei".hashCode() % 10 == 0, port.connect("drei"));
    }

    @Test
    public void scan() {
        Assert.assertTrue(port.scan("Sharknado"));
    }

    @Test
    public void alarm() {
        Assert.assertFalse(port.alarm());
    }

    @Test
    public void altitude() {
        port.setAltitude(10);
        Assert.assertEquals(10, port.determineAltitude(""));
    }
}
