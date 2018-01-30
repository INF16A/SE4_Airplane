package factory;

import org.junit.Assert;
import org.junit.Test;

public class OxygenBottleFactoryTest {
	@Test
	public void build(){
		Assert.assertNotNull(OxygenBottleFactory.build());
	}
}
