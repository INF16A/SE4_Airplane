package factory;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;

public class TCASFactoryTest {

    @Test
    public void build(){
        Assert.assertNotNull(TCASFactory.build());
    }
}
