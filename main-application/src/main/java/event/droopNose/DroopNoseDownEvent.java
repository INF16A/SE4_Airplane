package event.droopNose;

public class DroopNoseDownEvent {
    private int id;
    private int degrees;

    public DroopNoseDownEvent(int id, int degrees) {
        this.degrees = degrees;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getDegrees() {
        return degrees;
    }
}
