package event.SeatBeltSign;

public class SeatBeltSignOn {
    private boolean SeatBeltSign;

    public SeatBeltSignOn(boolean SeatBeltSign) {
        this.SeatBeltSign = SeatBeltSign;
    }

    public boolean getSeatBeltSign() {
        return SeatBeltSign;
    }

    public String toString() {
        return "event - " + SeatBeltSign + " : SeatBeltSignOn";
    }
}
