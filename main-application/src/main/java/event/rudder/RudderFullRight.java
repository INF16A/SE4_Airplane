package event.rudder;

public class RudderFullRight {


    private int id;

    public RudderFullRight(int id) {
        this.id = id;
    }

    public String toString() {

        return "{ RudderFullRight : id = " + id + " }";

    } public int getId() {
        return id;
    }
}
