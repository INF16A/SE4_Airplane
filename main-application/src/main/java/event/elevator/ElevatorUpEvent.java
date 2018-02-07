package event.elevator;

public class ElevatorUpEvent {
    private String phase;
    private int id;
    private int degrees;

    public ElevatorUpEvent(int id, int degrees, String phase) {
        this.degrees = degrees;
        this.id = id;
        this.phase = phase;
    }

    public int getId() {
        return id;
    }

    public int getDegrees() {
        return degrees;
    }

    public String getPhase() {
        return phase;
    }
}
