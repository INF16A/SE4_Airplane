import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SlatTest {
    Slat.Port port;
    private Slat slat;

    @Before
    public void init(){
        slat = Slat.getInstance();
        port = Slat.getInstance().port;
    }

    @Test
    public void neutral(){
        slat.port.neutral();
        Assert.assertEquals(0, slat.getDegree());
        Assert.assertEquals(0, port.neutral());
    }
    @Test
    public void fullDown(){
        slat.port.fullDown();
        Assert.assertEquals(-45, slat.getDegree());
        Assert.assertEquals(-45, port.fullDown());
    }
    @Test
    public void down30(){
        slat.port.down(30);
        Assert.assertEquals(-30, slat.getDegree());
    }
    @Test
    public void down30Port(){
        port.neutral();
        Assert.assertEquals(-30, port.down(30));
    }

    @Test
    public void down60(){
        slat.port.down(60);
        Assert.assertEquals(-45, slat.getDegree());
    }
    @Test
    public void down60Port(){
        Assert.assertEquals(-45, port.down(60));
    }
    @Test
    public void up30(){
        port.neutral();
        slat.port.up(30);
        Assert.assertEquals(30, slat.getDegree());
    }
    @Test
    public void up30Port(){
        port.neutral();
        Assert.assertEquals(30, port.up(30));
    }

    @Test
    public void up60(){
        slat.port.up(60);
        Assert.assertEquals(45, slat.getDegree());
    }
    @Test
    public void up60Port(){
        Assert.assertEquals(45, port.up(60));
    }
}
