package event.rudder;

public class RudderLeft {

    private int id;
    private int degree;

    public RudderLeft(int id, int degree) {
        this.id = id;
        this.degree = degree;
    }

    public int getDegree() {
        return degree;
    }

    public String toString() {

        return "{ RudderLeft : id = " + id + ", degree = " + degree + " }";

    } public int getId() {
        return id;
    }
}
