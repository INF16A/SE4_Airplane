package event.leftaileron;

public class LeftAileronFullDown {

    private int id;

    public LeftAileronFullDown(int id) {
        this.id = id;
    }

    public String toString() {

        return "{ LeftAileronFullDown : id = " + id + " }";

    }

    public int getId() {
        return id;
    }
}
