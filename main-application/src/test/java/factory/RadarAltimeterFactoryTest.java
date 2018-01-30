package factory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

public class RadarAltimeterFactoryTest {

    @Test
    public void build(){
        Assert.assertNotNull(RadarAltimeterFactory.build());
    }

    @Test
    public void on(){
        Object port = RadarAltimeterFactory.build();
        try {
            Method method = port.getClass().getDeclaredMethod("on");
            boolean on = (boolean) method.invoke(port);
            Assert.assertTrue(on);
        }
        catch (Exception e){}
    }

    @Test
    public void off(){
        Object port = RadarAltimeterFactory.build();
        try {
            Method method = port.getClass().getDeclaredMethod("off");
            boolean off = (boolean) method.invoke(port);
            Assert.assertFalse(off);
        }
        catch (Exception e){}
    }

}
