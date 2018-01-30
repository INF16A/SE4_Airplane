package factory;

import org.junit.Assert;
import org.junit.Test;

public class DeIcingSystemFactoryTest {
    @Test
    public void build(){
        Assert.assertNotNull(DeIcingSystemFactory.build());

    }
}
