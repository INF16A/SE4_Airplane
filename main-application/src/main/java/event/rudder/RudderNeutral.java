package event.rudder;

public class RudderNeutral {


    private int id;

    public RudderNeutral(int id) {
        this.id = id;
    }

    public String toString() {
        return "{ RudderNeutral : id = " + id + " }";
    }

    public int getId() {
        return id;
    }
}
