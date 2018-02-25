import factory.CostOptimizerFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CostOptimizerTest {

    private Object componentPort;

    @Test
    public void build() {
        componentPort = CostOptimizerFactory.build();
        assertNotNull(componentPort);
    }

}
