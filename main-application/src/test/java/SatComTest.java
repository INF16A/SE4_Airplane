import factory.SatComFactory;
import org.junit.Test;
import java.lang.reflect.Method;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class SatComTest {
    private Object componentPort;

    @Test
    public void build() {
        componentPort = SatComFactory.build();
        assertNotNull(componentPort);
    }

    @Test
    public void on() {
        componentPort = SatComFactory.build();
        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("on");
            boolean isOn = (boolean)onMethod.invoke(componentPort);
            assertEquals(true,isOn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void off() {
        componentPort = SatComFactory.build();
        try {
            Method offMethod = componentPort.getClass().getDeclaredMethod("off");
            boolean isOn = (boolean)offMethod.invoke(componentPort);
            assertEquals(false,isOn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void version() {
        componentPort = SatComFactory.build();
        try {
            Method offMethod = componentPort.getClass().getDeclaredMethod("version");
            String version = (String)offMethod.invoke(componentPort);
            assertEquals("SatCom 312.54",version);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void connect() {
        componentPort = SatComFactory.build();
        try {
            Method method1 = componentPort.getClass().getDeclaredMethod("on");
            method1.invoke(componentPort);
            Method offMethod = componentPort.getClass().getDeclaredMethod("connect", String.class, String.class);
            boolean connectResult = (boolean)offMethod.invoke(componentPort, new Object[]{"Ares4", "450Hz"});
            assertEquals(true, connectResult);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void receive() {
        componentPort = SatComFactory.build();
        try {
            Method method1 = componentPort.getClass().getDeclaredMethod("on");
            method1.invoke(componentPort);
            Method method2 = componentPort.getClass().getDeclaredMethod("connect", String.class, String.class);
            method2.invoke(componentPort,new Object[]{"Ares3", "350Hz"} );
            Method offMethod = componentPort.getClass().getDeclaredMethod("receive");
            String receiveResult = (String)offMethod.invoke(componentPort);
            assertEquals("No weather warning ahead", receiveResult);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void send() {
        componentPort = SatComFactory.build();
        try {
            Method offMethod = componentPort.getClass().getDeclaredMethod("send", String.class);
            String request = "Connection Status";
            offMethod.invoke(componentPort, new Object[]{request});
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
