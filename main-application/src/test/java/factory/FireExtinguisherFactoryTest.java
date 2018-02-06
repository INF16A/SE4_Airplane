package factory;

import org.junit.Assert;
import org.junit.Test;

public class FireExtinguisherFactoryTest {
    @Test
    public void build() {
        Assert.assertNotNull(FireExtinguisherFactory.build());

    }
}
