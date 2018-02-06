import factory.GPSFactory;
import org.junit.Test;

import java.lang.reflect.Method;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class GPSTest {
    private Object componentPort;

    @Test
    public void build() {
        componentPort = GPSFactory.build();
        assertNotNull(componentPort);
    }

    @Test
    public void on() {
        componentPort = GPSFactory.build();
        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("on");
            boolean isOn = (boolean) onMethod.invoke(componentPort);
            assertEquals(true, isOn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void off() {
        componentPort = GPSFactory.build();
        try {
            Method offMethod = componentPort.getClass().getDeclaredMethod("off");
            boolean isOn = (boolean) offMethod.invoke(componentPort);
            assertEquals(false, isOn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void version() {
        componentPort = GPSFactory.build();
        try {
            Method offMethod = componentPort.getClass().getDeclaredMethod("version");
            String version = (String) offMethod.invoke(componentPort);
            assertEquals("GPS 17.34", version);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void conncect() {
        componentPort = GPSFactory.build();
        try {
            Method method1 = componentPort.getClass().getDeclaredMethod("on");
            method1.invoke(componentPort);
            Method offMethod = componentPort.getClass().getDeclaredMethod("connect", String.class);
            String satellite = "Gallileo7";
            boolean connectResult = (boolean) offMethod.invoke(componentPort, new Object[]{satellite});
            assertEquals(true, connectResult);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void receive() {
        componentPort = GPSFactory.build();
        try {
            Method method1 = componentPort.getClass().getDeclaredMethod("on");
            method1.invoke(componentPort);
            Method method2 = componentPort.getClass().getDeclaredMethod("connect", String.class);
            method2.invoke(componentPort, new Object[]{"Galileo9"});
            Method offMethod = componentPort.getClass().getDeclaredMethod("receive");
            String receiveResult = (String) offMethod.invoke(componentPort);
            assertEquals("position is 52°31'12.025 N and 13°24'17.834 E", receiveResult);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void send() {
        componentPort = GPSFactory.build();
        try {
            Method offMethod = componentPort.getClass().getDeclaredMethod("send", String.class);
            String request = "Connection Status";
            offMethod.invoke(componentPort, new Object[]{request});
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
