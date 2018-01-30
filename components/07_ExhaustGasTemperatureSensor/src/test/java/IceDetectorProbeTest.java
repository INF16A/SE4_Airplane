import org.junit.Assert;
import org.junit.Test;

public class IceDetectorProbeTest {
    @Test
    public void TestVersion() {
        Assert.assertNotNull(new IceDetectorProbe().version());
    }

    @Test
    public void TestActivate() {
        new IceDetectorProbe().activate();
    }

    @Test
    public void TestDeactivate() {
        IceDetectorProbe iceDetectorProbe = new IceDetectorProbe();
        iceDetectorProbe.deactivate();
        //Assert.assertFalse(iceDetectorProbe.getClass().getDeclaredField("isActivated").getBoolean(iceDetectorProbe));
    }

    @Test
    public void TestDetect() {
        new IceDetectorProbe().detect();
    }

    @Test
    public void TestDetectString() {
        Assert.assertTrue(new IceDetectorProbe().detect("test"));
    }

    @Test
    public void TestDetectStringMatch() {
        Assert.assertTrue(new IceDetectorProbe().detect("test", "test"));
    }
}
