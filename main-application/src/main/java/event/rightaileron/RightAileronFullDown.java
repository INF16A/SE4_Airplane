package event.rightaileron;

public class RightAileronFullDown {

    private int id;

    public RightAileronFullDown(int id) {
        this.id = id;
    }

    public String toString() {

        return "{ RightAileronFullDown : id = " + id + " }";

    }

    public int getId() {
        return id;
    }
}
