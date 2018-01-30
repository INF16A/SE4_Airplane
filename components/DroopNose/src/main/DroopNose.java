package main;

public class DroopNose {
    public Port port;
    private static DroopNose instance = new DroopNose();

    private String manufacturer;
    private String type;
    private String id;
    private int degree;

    private DroopNose() {
        port = new Port();
    }

    public static DroopNose getInstance() {
        return instance;
    }

    private String innerVersion() {
        return "Version 0.2";
    }

    public class Port implements IDroopNose {
        public String version() {
            return innerVersion();
        }

        public int neutral() {
            return 0;
        }

        public int fullDown() {
            return 0;
        }

        public int down(int degree) {
            return 0;
        }

        public int up(int degree) {
            return 0;
        }
    }
}
