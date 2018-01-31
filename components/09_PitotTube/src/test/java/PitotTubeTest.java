import org.junit.Assert;
import org.junit.Test;

public class PitotTubeTest {

    PitotTube.Port port = PitotTube.getInstance().port;

    @Test
    public void measureStaticPressure(){
        Assert.assertEquals(10/7,port.measureStaticPressure());
    }

    @Test
    public void measureTotalPressure(){
        Assert.assertEquals(10/5,port.measureTotalPressure());
    }

    @Test
    public void measureVelocity(){
        Assert.assertEquals(10, port.measureVelocity());
    }

}
