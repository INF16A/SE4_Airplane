import factory.GenericFactory;
import org.junit.Assert;
import org.junit.Test;


public class DoorsTest {

    @Test
    public void testBulkCargoDoor()
    {
        Object result = GenericFactory.buildObjectByClassName("BulkCargoDoor");
        Assert.assertNotNull(result);
    }

    @Test
    public void testCrewDoor()
    {
        Object result = GenericFactory.buildObjectByClassName("CrewDoor");
        Assert.assertNotNull(result);
    }

    @Test
    public void testEmergencyExitDoor()
    {
        Object result = GenericFactory.buildObjectByClassName("EmergencyExitDoor");
        Assert.assertNotNull(result);
    }

    @Test
    public void testGearDoor()
    {
        Object result = GenericFactory.buildObjectByClassName("GearDoor");
        Assert.assertNotNull(result);
    }
}
