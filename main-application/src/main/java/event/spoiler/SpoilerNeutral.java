package event.spoiler;

public class SpoilerNeutral {

    private int id;

    public SpoilerNeutral(int id) {
        this.id = id;
    }

    public String toString() {
        return "{ SpoilerNeutral : id = " + id + " }";
    }

    public int getId() {
        return id;
    }

}