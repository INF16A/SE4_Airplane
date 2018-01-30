package event.leftaileron;

public class LeftAileronUp {
    private int id;
    private int degree;

    public LeftAileronUp(int id, int degree) {
        this.id = id;
        this.degree = degree;
    }


    public int getDegree() {
        return degree;
    }
    public String toString() {

        return "{ LeftAileronUp : id = " + id + ", degree = " + degree + " }";

    }

    public int getId() {
        return id;
    }
}
