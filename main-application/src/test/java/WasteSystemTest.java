import factory.WasteSystemFactory;
import org.junit.Assert;
import org.junit.Test;

public class WasteSystemTest {

    @Test
    public void TestWasteSystemLoad() {
        Object o = WasteSystemFactory.build();
        Assert.assertNotNull(o);
    }
}
