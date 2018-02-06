package factory;

import org.junit.Assert;
import org.junit.Test;

public class TurbulentAirFlowSensorFactoryTest {

    @Test
    public void build() {
        Assert.assertNotNull(TurbulentAirFlowSensorFactory.build());
    }

}
