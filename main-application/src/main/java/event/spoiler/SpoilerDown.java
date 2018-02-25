package event.spoiler;

public class SpoilerDown {
    private int id;
    private int degree;

    public SpoilerDown(int id, int degree) {
        this.id = id;
        this.degree = degree;
    }

    public int getDegree() {
        return degree;
    }

    public String toString() {

        return "{ SpoilerDown : id = " + id + ", degree = " + degree + " }";

    }

    public int getId() {
        return id;
    }
}
