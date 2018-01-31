package event.spoiler;

public class SpoilerUp {
    private int id;
    private int degree;

    public SpoilerUp(int id, int degree) {
        this.id = id;
        this.degree = degree;
    }

    public int getDegree() {
        return degree;
    }

    public String toString() {

        return "{ SpoilerUp : id = " + id + ", degree = " + degree + " }";

    }
    public int getId() {
        return id;
    }
}
