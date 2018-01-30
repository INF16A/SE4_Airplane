import org.junit.Assert;
import org.junit.Test;

public class TestWasteSystem {

    @Test
    public void TestWasteSystemOn() {
        WasteSystem ws = new WasteSystem();
        Assert.assertTrue(ws.on());
    }

    @Test
    public void TestWasteSystemOnFalse() {
        WasteSystem ws = new WasteSystem();
        ws.on();
        Assert.assertFalse(ws.on());
    }

    @Test
    public void TestWasteSystemClean() {
        WasteSystem ws = new WasteSystem();
        Assert.assertTrue(ws.clean());
    }

    @Test
    public void TestWasteSystemCleanFalse() {
        WasteSystem ws = new WasteSystem();
        ws.clean();
        Assert.assertFalse(ws.clean());
    }
}
