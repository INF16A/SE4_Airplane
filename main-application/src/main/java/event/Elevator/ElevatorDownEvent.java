package event.Elevator;

public class ElevatorDownEvent {
    private int id;
    private int degrees;

    public ElevatorDownEvent(int id, int degrees) {
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
