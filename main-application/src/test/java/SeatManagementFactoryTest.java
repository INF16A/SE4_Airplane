import factory.SeatManagementFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by npor1112 on 30.01.2018.
 */
public class SeatManagementFactoryTest {

    @Test
    public void testBuild() {
        Assert.assertNotNull(SeatManagementFactory.build());
    }
}
