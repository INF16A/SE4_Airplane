package factory;

import org.junit.Assert;
import org.junit.Test;

public class PitotTubeFactoryTest {

    @Test
    public void build(){
        Assert.assertNotNull(PitotTubeFactory.build());
    }
}
