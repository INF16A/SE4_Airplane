import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VHFTest {

    private VHF vhf;

    @Before
    public void init(){
        vhf = new VHF();
    }

    @Test
    public void version(){
        assertEquals("VHF 27", vhf.version());
    }

    @Test
    public void testOn(){
        assertTrue(vhf.on());
    }

    @Test
    public void search(){
        assertArrayEquals(new String[]{"182.67", "133.70", "123.45", "120.42"}, vhf.search());
    }

    @Test
    public void forwardChannel(){
        assertEquals("Next channel selected", vhf.forwardChannel());
    }

    @Test
    public void backwardChannel(){
        assertEquals("Previous channel selected", vhf.backwardChannel());
    }

    @Test
    public void selectChannel(){
        assertEquals("182.98", vhf.selectChannel("182.98"));
    }

    @Test
    public void off(){ assertFalse(vhf.off()); }
}
