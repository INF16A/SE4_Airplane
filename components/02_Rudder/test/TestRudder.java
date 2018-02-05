import static org.junit.Assert.*;

public class TestRudder {

    @org.junit.Test
    public void testManufacturer() {
        Rudder.Port rudder = Rudder.getInstance().port;

        rudder.setManufacturer("Boeing");

        assertEquals("Boeing", rudder.getManufacturer());
    }

    @org.junit.Test
    public void testMaxDegree() {
        Rudder.Port rudder = Rudder.getInstance().port;

        rudder.fullRight();

        assertEquals(Rudder.MAX_DEGREE, rudder.getDegree());
    }

    @org.junit.Test
    public void testMaxDegreeAsLimit() {
        Rudder.Port rudder = Rudder.getInstance().port;

        rudder.fullRight();
        rudder.right(5);

        assertEquals(Rudder.MAX_DEGREE, rudder.getDegree());
    }


    @org.junit.Test
    public void testMinDegreeAsLimit() {
        Rudder.Port rudder = Rudder.getInstance().port;

        rudder.fullLeft();
        rudder.left(10);

        assertEquals(Rudder.MIN_DEGREE, rudder.getDegree());
    }

    @org.junit.Test
    public void testNeutral() {
        Rudder.Port rudder = Rudder.getInstance().port;

        rudder.fullRight();
        rudder.neutral();

        assertEquals(0, rudder.getDegree());
    }

    @org.junit.Test
    public void testReturns() {
        Rudder.Port rudder = Rudder.getInstance().port;

        rudder.neutral();
        int degree = rudder.right(5);

        assertEquals(rudder.getDegree(), degree);
    }
}
