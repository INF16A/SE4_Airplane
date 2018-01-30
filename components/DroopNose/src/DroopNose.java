import IDroopNose;

public class DroopNose {
    public Port port;
    private static DroopNose instance = new DroopNose();

    private String manufacturer;
    private String type;
    private String id;
    private int degree;

    private DroopNose(String id, String manufacturer, String type) {
        port = new Port();
        this.id = id;
        this.manufacturer = manufacturer;
        this. type = type;
    }

    public static DroopNose getInstance() {
        return instance;
    }

    private String innerVersion() {
        return "Version 0.2";
    }

    public class Port implements IDroopNose {
        @Override
        public String version() {
            return innerVersion();
        }

        @Override
        public int neutral() {
            return 0;
        }

        @Override
        public int fullDown() {
            return 0;
        }

        @Override
        public int down(int degree) {
            return 0;
        }

        @Override
        public int up(int degree) {
            return 0;
        }
    }
}
