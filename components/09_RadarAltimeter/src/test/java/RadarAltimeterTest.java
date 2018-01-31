import org.junit.Assert;
import org.junit.Test;

public class RadarAltimeterTest {

    RadarAltimeter.Port port = RadarAltimeter.getInstance().port;

    @Test
    public void on(){
        Assert.assertTrue(port.on());
    }

    @Test
    public void off(){
        Assert.assertFalse(port.off());
    }

    @Test
    public void receive(){
        Assert.assertEquals("drei".hashCode(),port.receive("drei"));
    }

    @Test
    public void measureAltitude(){
        Assert.assertEquals(10,port.measureAltitude());
    }
}
