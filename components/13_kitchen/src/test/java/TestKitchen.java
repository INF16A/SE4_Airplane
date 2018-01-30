import org.junit.Assert;
import org.junit.Test;

public class TestKitchen {

    @Test
    public void TestKitchenLocked() {
        Kitchen kitchen = new Kitchen();
        Assert.assertTrue(kitchen.lock());
    }

    @Test
    public void TestKitchenLockedFalse() {
        Kitchen kitchen = new Kitchen();
        kitchen.lock();
        Assert.assertFalse(kitchen.lock());
    }
}
