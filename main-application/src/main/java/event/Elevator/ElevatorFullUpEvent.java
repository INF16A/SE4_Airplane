package event.Elevator;

public class ElevatorFullUpEvent {
    private String phase;
    private int id;

    public ElevatorFullUpEvent(int id, String phase) {
        this.phase = phase;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getPhase() {
        return phase;
    }
}
