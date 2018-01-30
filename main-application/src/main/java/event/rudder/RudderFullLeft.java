package event.rudder;

public class RudderFullLeft {


    private int id;

    public RudderFullLeft(int id) {
        this.id = id;
    }

    public String toString() {

        return "{ RudderFullLeft : id = " + id + " }";

    } public int getId() {
        return id;
    }
}
