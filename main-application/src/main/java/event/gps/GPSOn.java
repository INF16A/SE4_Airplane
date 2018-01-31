package event.gps;

public class GPSOn {
        private String phase;

        public GPSOn(String phase) {
            this.phase = phase;
        }

        public String getPhase() {
            return phase;
        }

        public String toString() {
            return "event - " + phase + " : GPSOn";
        }
}
