import org.junit.Assert;
import org.junit.Test;

public class IceDetectorProbeTest {
    @Test
    public void TestVersion() {
        Assert.assertNotNull(IceDetectorProbe.getInstance().port.version());
    }

    @Test
    public void TestActivate() {
        IceDetectorProbe.getInstance().port.activate();
    }

    @Test
    public void TestDeactivate() {
        IceDetectorProbe.getInstance().port.deactivate();
    }

    @Test
    public void TestDetect() {
        IceDetectorProbe.getInstance().port.detect();
    }

    @Test
    public void TestDetectString() {
        Assert.assertTrue(IceDetectorProbe.getInstance().port.detect("test"));
    }

    @Test
    public void TestDetectStringMatch() {
        Assert.assertTrue(IceDetectorProbe.getInstance().port.detect("test", "test"));
    }
}
