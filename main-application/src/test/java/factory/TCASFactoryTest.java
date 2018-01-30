package factory;

import org.junit.Assert;
import org.junit.Test;

public class TCASFactoryTest {

    @Test
    public void build() {
        Assert.assertNotNull(TCASFactory.build());
    }

}
