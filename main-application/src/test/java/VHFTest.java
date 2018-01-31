import factory.VHFFactory;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Method;

public class VHFTest {

    private Object componentPort;

    @Test
    public void build() {
        componentPort = VHFFactory.build();
        assertNotNull(componentPort);
    }

    @Test
    public void version(){
        componentPort = VHFFactory.build();

        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("version");
            String version = (String)onMethod.invoke(componentPort);
            assertEquals("VHF 27" , version);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testOn(){
        componentPort = VHFFactory.build();

        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("on");
            boolean on = (boolean)onMethod.invoke(componentPort);
            assertTrue(on);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void search(){
        componentPort = VHFFactory.build();

        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("search");
            String[] channelList = (String[])onMethod.invoke(componentPort);
            assertArrayEquals(new String[]{"182.67", "133.70", "123.45", "120.42"}, channelList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void forwardChannel(){
        componentPort = VHFFactory.build();

        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("forwardChannel");
            String forwardChannel = (String)onMethod.invoke(componentPort);
            assertEquals("Next channel selected", forwardChannel);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void backwardChannel(){
        componentPort = VHFFactory.build();

        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("backwardChannel");
            String backwardChannel = (String)onMethod.invoke(componentPort);
            assertEquals("Previous channel selected", backwardChannel);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void selectChannel(){
        componentPort = VHFFactory.build();

        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("selectChannel", String.class);
            String selectedChannel = (String)onMethod.invoke(componentPort, new Object[]{"182.98"});
            assertEquals("182.98", selectedChannel);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void off(){
        componentPort = VHFFactory.build();

        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("off");
            boolean on = (boolean)onMethod.invoke(componentPort);
            assertFalse(on);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
