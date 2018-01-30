import org.junit.Assert;
import org.junit.Test;

public class TestEscapeSlide {

    @Test
    public void TestEscapeSlideActivate() {
        EscapeSlide es = new EscapeSlide();
        Assert.assertTrue(es.activate());
    }

    @Test
    public void TestEscapeSlideAlreadyActivate() {
        EscapeSlide es = new EscapeSlide();
        es.activate();
        Assert.assertFalse(es.activate());
    }
}
