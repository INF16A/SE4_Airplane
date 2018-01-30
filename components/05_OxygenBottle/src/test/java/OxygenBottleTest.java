
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OxygenBottleTest {
	private OxygenBottle.Port port;

	@Before
	public void init(){
		port = OxygenBottle.getInstance().port;
	}

	@Test
	public void version(){
		Assert.assertEquals("OxygenBottle - Version 1.0", port.version());
	}

	@Test
	public void refill() {
		Assert.assertEquals(100, port.refill());
	}

	@Test
	public void refillAmount() {
		port.takeOut(100);
		int cur = port.refill(0);
		int after = port.refill(400);
		Assert.assertTrue(after > cur);
	}

	@Test
	public void takeOut() {
		int cur = port.refill(20);
		int after = port.takeOut(1);
		Assert.assertTrue(after < cur);
	}
}