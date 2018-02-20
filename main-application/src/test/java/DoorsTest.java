import factory.BulkCargoDoorFactory;
import factory.CrewDoorFactory;
import factory.EmergencyExitDoorFactory;
import factory.GearDoorFactory;
import org.junit.Assert;
import org.junit.Test;


    public class DoorsTest {

        private Object result;

        @Test
        public void testBulkCargoDoor()
        {
            result = BulkCargoDoorFactory.build();
            Assert.assertNotNull(result);
        }

        @Test
        public void testCrewDoor()
        {
            result = CrewDoorFactory.build();
            Assert.assertNotNull(result);
        }

        @Test
        public void testEmergencyExitDoor()
        {
            result = EmergencyExitDoorFactory.build();
            Assert.assertNotNull(result);
        }

        @Test
        public void testGearDoor()
        {
            result = GearDoorFactory.build();
            Assert.assertNotNull(result);
        }
    }

