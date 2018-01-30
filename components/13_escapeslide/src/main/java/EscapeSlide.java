public class EscapeSlide implements IEscapeSlide {
    private String manufacturer;
    private String type;
    private String id;
    private boolean isActivated;

    public EscapeSlide() {
        manufacturer = "INF16B";
        type = "A good one";
        id = "1";
    }

    public String version() {
        return "Escapeslide 1.0";
    }

    public boolean activate() {
        if(isActivated == true)
            return false;

        isActivated = true;
        return true;
    }

    public void test() {
    }
}
