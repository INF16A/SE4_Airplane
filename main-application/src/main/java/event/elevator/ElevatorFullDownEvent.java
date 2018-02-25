package event.elevator;

public class ElevatorFullDownEvent {
    private String phase;
    private int id;

    public ElevatorFullDownEvent(int id, String phase) {
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
