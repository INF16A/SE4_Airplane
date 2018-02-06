import static org.junit.Assert.*;

public class TestSpoiler {

    @org.junit.Test
    public void testManufacturer() {
        Spoiler.Port spoiler = Spoiler.getInstance().port;

        spoiler.setManufacturer("Boeing");

        assertEquals("Boeing", spoiler.getManufacturer());
    }

    @org.junit.Test
    public void testMaxDegree() {
        Spoiler.Port spoiler = Spoiler.getInstance().port;

        spoiler.fullUp();

        assertEquals(Spoiler.MAX_DEGREE, spoiler.getDegree());
    }

    @org.junit.Test
    public void testMaxDegreeAsLimit() {
        Spoiler.Port spoiler = Spoiler.getInstance().port;

        spoiler.fullUp();
        spoiler.up(5);

        assertEquals(Spoiler.MAX_DEGREE, spoiler.getDegree());
    }

    @org.junit.Test
    public void testNeutral() {
        Spoiler.Port spoiler = Spoiler.getInstance().port;

        spoiler.fullUp();
        spoiler.neutral();

        assertEquals(0, spoiler.getDegree());
    }

    @org.junit.Test
    public void testReturns() {
        Spoiler.Port spoiler = Spoiler.getInstance().port;

        spoiler.neutral();
        int degree = spoiler.up(5);

        assertEquals(spoiler.getDegree(), degree);
    }
}
