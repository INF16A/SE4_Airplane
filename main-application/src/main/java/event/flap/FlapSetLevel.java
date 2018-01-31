package event.flap;

public class FlapSetLevel {
    private int id;
    private int level;

    public FlapSetLevel(int id, int level) {
        this.id = id;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }
}
