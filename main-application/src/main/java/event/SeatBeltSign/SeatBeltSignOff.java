package event.SeatBeltSign;

public class SeatBeltSignOff {
    private boolean SeatBeltSign;

    public SeatBeltSignOff(boolean SeatBeltSign) {
        this.SeatBeltSign = SeatBeltSign;
    }

    public boolean getSeatBeltSign() {
        return SeatBeltSign;
    }

    public String toString() {
        return "event - " + SeatBeltSign + " : SeatBeltSignOff";
    }
}