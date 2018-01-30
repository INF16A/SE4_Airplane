package event.rudder;

public class RudderRight {

    private int id;
    private int degree;

    public RudderRight(int id, int degree) {
        this.id = id;
        this.degree = degree;
    }

    public int getDegree() {
        return degree;
    }

    public String toString() {

        return "{ RudderRight : id = " + id + ", degree = " + degree + " }";

    }

    public int getId() {
        return id;
    }

}
