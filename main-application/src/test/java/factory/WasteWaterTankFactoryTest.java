package factory;

import org.junit.Assert;
import org.junit.Test;

public class WasteWaterTankFactoryTest {
	@Test
	public void build(){
		Assert.assertNotNull(WasteWaterTankFactory.build());
	}
}
