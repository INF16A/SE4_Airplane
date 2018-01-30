package test.java;

import main.java.FuelTank;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FuelTankTest {
	private FuelTank.Port port;

	@BeforeEach
	public void init(){
		port = FuelTank.getInstance().port;
	}

	@Test
	public void version(){
		assertEquals("FuelTank - Version 1.0", port.version());
	}

	@Test
	public void refill() {
		assertEquals(250, port.refill());
	}

	@Test
	public void refillAmount() {
		port.takeOut(100);
		int cur = port.refill(0);
		int after = port.refill(400);
		assertTrue(after > cur);
	}

	@Test
	public void takeOut() {
		int cur = port.refill(20);
		int after = port.takeOut(1);
		assertTrue(after < cur);
	}
}