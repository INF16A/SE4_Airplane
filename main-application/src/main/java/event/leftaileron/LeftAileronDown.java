package event.leftaileron;

public class LeftAileronDown {

    private int id;
    private int degree;

    public LeftAileronDown(int id, int degree) {
        this.id = id;
        this.degree = degree;
    }

    public int getId() {
        return id;
    }

    public int getDegree() {
        return degree;
    }

    public String toString() {

        return "{ LeftAileronDown : id = " + id + ", degree = " + degree + " }";

    }

}
