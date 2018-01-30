package event.rightaileron;

public class RightAileronDown {

    private int id;
    private int degree;

    public RightAileronDown(int id, int degree) {
        this.id = id;
        this.degree = degree;
    }

    public int getDegree() {
        return degree;
    }

    public String toString() {

        return "{ RightAileronDown : id = " + id + ", degree = " + degree + " }";

    }
    public int getId() {
        return id;
    }
}
