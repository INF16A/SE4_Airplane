package event.leftaileron;

public class LeftAileronFullUp {

    private int id;

    public LeftAileronFullUp(int id) {
        this.id = id;
    }


    public String toString() {

        return "{ LeftAileronFullUp : id = " + id + " }";

    }

    public int getId() {
        return id;
    }
}
