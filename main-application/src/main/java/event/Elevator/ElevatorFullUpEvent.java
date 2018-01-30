package event.Elevator;

public class ElevatorFullUpEvent {
    private int id;

    public ElevatorFullUpEvent(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
