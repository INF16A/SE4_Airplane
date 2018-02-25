import static org.junit.Assert.*;

public class TestRightAileron {

    @org.junit.Test
    public void testManufacturer() {
        RightAileron.Port rightAileron = RightAileron.getInstance().port;

        rightAileron.setManufacturer("Boeing");

        assertEquals("Boeing", rightAileron.getManufacturer());
    }

    @org.junit.Test
    public void testMaxDegree() {
        RightAileron.Port rightAileron = RightAileron.getInstance().port;

        rightAileron.fullUp();

        assertEquals(RightAileron.MAX_DEGREE, rightAileron.getDegree());
    }

    @org.junit.Test
    public void testMaxDegreeAsLimit() {
        RightAileron.Port rightAileron = RightAileron.getInstance().port;

        rightAileron.fullUp();
        rightAileron.up(5);

        assertEquals(RightAileron.MAX_DEGREE, rightAileron.getDegree());
    }


    @org.junit.Test
    public void testMinDegreeAsLimit() {
        RightAileron.Port rightAileron = RightAileron.getInstance().port;

        rightAileron.fullDown();
        rightAileron.down(10);

        assertEquals(RightAileron.MIN_DEGREE, rightAileron.getDegree());
    }

    @org.junit.Test
    public void testNeutral() {
        RightAileron.Port rightAileron = RightAileron.getInstance().port;

        rightAileron.fullUp();
        rightAileron.neutral();

        assertEquals(0, rightAileron.getDegree());
    }

    @org.junit.Test
    public void testReturns() {
        RightAileron.Port rightAileron = RightAileron.getInstance().port;

        rightAileron.neutral();
        int degree = rightAileron.up(5);

        assertEquals(rightAileron.getDegree(), degree);
    }
}
