package event.SmokingSign;

public class SmokingSignOn {
    private boolean SmokingSign;

    public SmokingSignOn(boolean SmokingSign) {
        this.SmokingSign = SmokingSign;
    }

    public boolean getSmokingSign() {
        return SmokingSign;
    }

    public String toString() {
        return "event - " + SmokingSign + " : SmokingSignOn";
    }
}