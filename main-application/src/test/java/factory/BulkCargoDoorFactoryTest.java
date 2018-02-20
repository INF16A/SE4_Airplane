package factory;

import org.junit.Assert;
import org.junit.Test;

public class BulkCargoDoorFactoryTest {

    @Test
    public void build() {
        Assert.assertNotNull(BulkCargoDoorFactory.build());
    }
}
