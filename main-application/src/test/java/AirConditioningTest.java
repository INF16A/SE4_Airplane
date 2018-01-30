import factory.AirConditioningFactory;
import org.junit.Assert;
import org.junit.Test;

public class AirConditioningTest {

    @Test
    public void TestAirConditioningLoad() {
        Object o = AirConditioningFactory.build();
        Assert.assertNotNull(o);
    }

}
