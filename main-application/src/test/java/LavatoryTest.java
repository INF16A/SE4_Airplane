import factory.LavatoryFactory;
import org.junit.Assert;
import org.junit.Test;

public class LavatoryTest {

    @Test
    public void TestLavatoryLoad() {
        Object o = LavatoryFactory.build();
        Assert.assertNotNull(o);
    }
}