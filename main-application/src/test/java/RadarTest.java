import factory.RadarFactory;
import org.junit.Test;
import java.lang.reflect.Method;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class RadarTest {
    private Object componentPort;

    @Test
    public void build() {
        componentPort = RadarFactory.build();
        assertNotNull(componentPort);
    }
    @Test
    public void on() {
        componentPort = RadarFactory.build();
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
        componentPort = RadarFactory.build();
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
        componentPort = RadarFactory.build();
        try {
            Method offMethod = componentPort.getClass().getDeclaredMethod("version");
            String version = (String)offMethod.invoke(componentPort);
            assertEquals("Radar 0.18.123",version);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void scan() {
        componentPort = RadarFactory.build();
        try {
            Method offMethod = componentPort.getClass().getDeclaredMethod("scan", String.class);
            String environment = "Cloud freeSpace bird Cloud";
            boolean scanResult = (boolean)offMethod.invoke(componentPort, new Object[]{environment});
            assertEquals(true, scanResult);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
