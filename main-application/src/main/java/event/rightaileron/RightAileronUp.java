package event.rightaileron;

public class RightAileronUp {

    private int id;
    private int degree;

    public RightAileronUp(int id, int degree) {
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

        return "{ LeftAileronUp : id = " + id + ", degree = " + degree + " }";

    }

}
