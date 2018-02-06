package event.SmokingSign;

public class SmokingSignOff {
    private boolean SmokingSign;

    public SmokingSignOff(boolean SmokingSign) {
        this.SmokingSign = SmokingSign;
    }

    public boolean getSmokingSign() {
        return SmokingSign;
    }

    public String toString() {
        return "event - " + SmokingSign + " : SmokingSignOff";
    }
}