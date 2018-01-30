package event.spoiler;

public class SpoilerFullUp {
    private int id;

    public SpoilerFullUp(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String toString() {

        return "{ SpoilerFullUp : id = " + id + " }";

    }
}