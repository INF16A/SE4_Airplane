package event.leftaileron;

public class LeftAileronNeutral {
    private int id;

    public LeftAileronNeutral(int id) {
        this.id = id;
    }

    public String toString() {
        return "{ LeftAileronNeutral : id = " + id + " }";
    }

    public int getId() {
        return id;
    }
}
