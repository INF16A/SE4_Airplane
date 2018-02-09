import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FlapTest {
    private Flap.Port port;
    private Flap flap;

    @Before
    public void init(){
        flap = Flap.getInstance();
        port = Flap.getInstance().port;
    }

    @Test
    public void neutral(){
        flap.port.neutral();
        Assert.assertEquals(0, flap.getDegree());
        Assert.assertEquals(0, port.neutral());
    }
    @Test
    public void levelOne(){
        flap.port.levelOne();
        Assert.assertEquals(15, port.levelOne());
        Assert.assertEquals(15, flap.getDegree());
    }
    @Test
    public void levelTwo(){
        flap.port.levelTwo();
        Assert.assertEquals(30, flap.getDegree());
        Assert.assertEquals(30, port.levelTwo());
    }
    @Test
    public void levelThree(){
        flap.port.levelThree();
        Assert.assertEquals(45, flap.getDegree());
        Assert.assertEquals(45, port.levelThree());
    }
}
