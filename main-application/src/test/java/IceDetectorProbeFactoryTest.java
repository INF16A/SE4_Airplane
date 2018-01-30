import factory.IceDetectorProbeFactory;
import org.junit.Assert;
import org.junit.Test;

public class IceDetectorProbeFactoryTest {
    @Test
    public void Build() {
        Assert.assertNotNull(IceDetectorProbeFactory.build());
    }
}
