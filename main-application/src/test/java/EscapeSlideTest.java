import factory.EscapeSlideFactory;
import org.junit.Assert;
import org.junit.Test;

public class EscapeSlideTest {

    @Test
    public void TestEscapeSlideLoad() {
        Object o = EscapeSlideFactory.build();
        Assert.assertNotNull(o);
    }
}
