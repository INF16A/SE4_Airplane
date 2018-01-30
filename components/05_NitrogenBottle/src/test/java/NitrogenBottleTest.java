package test.java;

import main.java.NitrogenBottle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NitrogenBottleTest {
	private NitrogenBottle.Port port;

	@Before
	public void init(){
		port = NitrogenBottle.getInstance().port;
	}

	@Test
	public void version(){
		Assert.assertEquals("NitrogenBottleRefill - Version 1.0", port.version());
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
