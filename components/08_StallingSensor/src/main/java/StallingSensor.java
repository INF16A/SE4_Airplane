public class StallingSensor implements IStallingSensor{

    protected String manufactuerer;
    protected String type;
    protected String id;
    protected boolean isAlarm;

    private boolean alarm;

    public String version() {
        return null;
    }

    public int measure(int airFlow) {
        return 0;
    }

    public boolean alarm() {
        return false;
    }
}
