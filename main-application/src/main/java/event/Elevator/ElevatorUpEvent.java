package event.Elevator;

public class ElevatorUpEvent {
    private int id;
    private int degrees;

    public ElevatorUpEvent(int id, int degrees) {
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
