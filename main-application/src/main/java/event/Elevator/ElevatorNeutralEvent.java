package event.Elevator;

public class ElevatorNeutralEvent {
    private String phase;
    private int id;

    public ElevatorNeutralEvent(int id, String phase) {
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
