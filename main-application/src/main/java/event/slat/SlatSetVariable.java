package event.slat;

public class SlatSetVariable {
    private int id;
    private int direction;
    private int degree;

    public SlatSetVariable(int id, int direction, int degree) {
        this.id = id;
        this.direction = direction;
        this.degree = degree;
    }


    public int getId() {
        return id;
    }

    public int getDirection() {
        return direction;
    }

    public int getDegree() {
        return degree;
    }
}
