public class Slat implements ISlat {
    private String manufacturer;
    private String type;
    private String id;
    private int degree;

    @Override
    public String version() {
        return null;
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
