

import static org.junit.Assert.*;

public class TestLeftAileron {

    @org.junit.Test
    public void testManufacturer(){
        LeftAileron.Port leftAileron = LeftAileron.getInstance().port;

        leftAileron.setManufacturer("Boeing");

        assertEquals("Boeing", leftAileron.getManufacturer());
    }

    @org.junit.Test
    public void testMaxDegree(){
        LeftAileron.Port leftAileron = LeftAileron.getInstance().port;

        leftAileron.fullUp();

        assertEquals(LeftAileron.MAX_DEGREE, leftAileron.getDegree());
    }

    @org.junit.Test
    public void testMaxDegreeAsLimit(){
        LeftAileron.Port leftAileron = LeftAileron.getInstance().port;

        leftAileron.fullUp();
        leftAileron.up(5);

        assertEquals(LeftAileron.MAX_DEGREE, leftAileron.getDegree());
    }


    @org.junit.Test
    public void testMinDegreeAsLimit(){
        LeftAileron.Port leftAileron = LeftAileron.getInstance().port;

        leftAileron.fullDown();
        leftAileron.down(10);

        assertEquals(LeftAileron.MIN_DEGREE, leftAileron.getDegree());
    }

    @org.junit.Test
    public void testNeutral(){
        LeftAileron.Port leftAileron = LeftAileron.getInstance().port;

        leftAileron.fullUp();
        leftAileron.neutral();

        assertEquals(0, leftAileron.getDegree());
    }

    @org.junit.Test
    public void testReturns(){
        LeftAileron.Port leftAileron = LeftAileron.getInstance().port;

        leftAileron.neutral();
        int degree = leftAileron.up(5);

        assertEquals(leftAileron.getDegree(), degree);
    }
}
