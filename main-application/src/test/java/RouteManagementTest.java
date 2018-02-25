import factory.RouteManagementFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class RouteManagementTest {

    private Object componentPort;

    @Test
    public void build() {
        componentPort = RouteManagementFactory.build();
        assertNotNull(componentPort);
    }

}
