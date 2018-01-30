import factory.KitchenFactory;
import org.junit.Assert;
import org.junit.Test;

public class KitchenTest {

    @Test
    public void TestKitchenBuild() {
        Object o = KitchenFactory.build();
        Assert.assertNotNull(o);
    }
}
