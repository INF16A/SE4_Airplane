package event.DroopNose;

public class DroopNoseUpEvent {
    private int id;
    private int degrees;

    public DroopNoseUpEvent(int id, int degrees) {
        this.degrees = degrees;
        this.id = id;
    }

    public int getDegrees() {
        return degrees;
    }

    public int getId() {
        return id;
    }
}
