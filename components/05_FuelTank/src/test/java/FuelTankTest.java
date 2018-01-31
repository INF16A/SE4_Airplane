
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FuelTankTest {
	private FuelTank.Port port;

	@Before
	public void init(){
		port = FuelTank.getInstance().port;
	}

	@Test
	public void version(){
		Assert.assertEquals("FuelTank - Version 1.0", port.version());
	}

	@Test
	public void refill() {
		Assert.assertEquals(250, port.refill());
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