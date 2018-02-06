public class EscapeSlide {
    private static EscapeSlide instance = new EscapeSlide();
    public Port port;
    private String manufacturer;
    private String type;
    private String id;
    private boolean isActivated;
    private EscapeSlide() {
        manufacturer = "INF16B";
        type = "A good one";
        id = "1";
        port = new Port();
    }

    public static EscapeSlide getInstance() {
        return instance;
    }

    private String innerVersion() {
        return "Escapeslide 1.0";
    }

    private boolean innerActivate() {
        if (isActivated == true)
            return false;

        isActivated = true;
        return true;
    }

    private void innerTest() {
    }

    public class Port implements IEscapeSlide {

        public String version() {
            return innerVersion();
        }

        public boolean activate() {
            return innerActivate();
        }

        public void test() {
            innerTest();
        }
    }
}