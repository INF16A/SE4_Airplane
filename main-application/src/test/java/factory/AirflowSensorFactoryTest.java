package factory;

import org.junit.Assert;
import org.junit.Test;

public class AirflowSensorFactoryTest {

    @Test
    public void build(){
        Assert.assertNotNull(AirflowSensorFactory.build());
    }

}
