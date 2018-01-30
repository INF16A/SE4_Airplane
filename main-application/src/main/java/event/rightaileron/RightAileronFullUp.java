package event.rightaileron;

public class RightAileronFullUp {

    private int id;

    public RightAileronFullUp(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String toString() {

        return "{ RightAileronFullUp : id = " + id + " }";

    }
}
