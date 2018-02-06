package factory;

import org.junit.Assert;
import org.junit.Test;

public class NitrogenBottleFactoryTest {
    @Test
    public void build() {
        Assert.assertNotNull(NitrogenBottleFactory.build());
    }
}
