package event.Elevator;

public class ElevatorFullDownEvent {
    private int id;

    public ElevatorFullDownEvent(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
