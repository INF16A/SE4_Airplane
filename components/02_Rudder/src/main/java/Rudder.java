
public class Rudder {

    private static Rudder instance = new Rudder();

    public static Rudder getInstance() {
        return instance;
    }

    public Port port;

    private Rudder() {
        port = new Port();
    }

    private String manufacturer;
    private String type;
    private String id;
    private int degree; // negative = left, positive = right

    public static final int MAX_DEGREE = 26;
    public static final int MIN_DEGREE = -26;

    public class Port implements IRudder {

        public String getManufacturer() {
            return manufacturer;
        }

        public void setManufacturer(String _manufacturer) {
            manufacturer = _manufacturer;
        }

        public String getType() {
            return type;
        }

        public void setType(String _type) {
            type = _type;
        }

        public String getId() {
            return id;
        }

        public void setId(String _id) {
            id = _id;
        }

        public int getDegree() {
            return degree;
        }


        @Override
        public String version() {
            return innerMethodGetVersion();
        }

        @Override
        public int neutral() {
            innerSetDegree(0);
            return innerGetDegree();
        }

        @Override
        public int fullRight() {
            innerSetDegree(MAX_DEGREE);
            return innerGetDegree();
        }

        @Override
        public int fullLeft() {
            innerSetDegree(MIN_DEGREE);
            return innerGetDegree();
        }

        @Override
        public int right(int degree) {
            innerAddDegree(degree);
            return innerGetDegree();
        }

        @Override
        public int left(int degree) {
            innerAddDegree(degree * -1);
            return innerGetDegree();
        }
    }

    private void innerAddDegree(int addValue) {
        innerSetDegree(this.degree + addValue);
    }

    private void innerSetDegree(int totalValue) {
        if (totalValue < MIN_DEGREE) {
            this.degree = MIN_DEGREE;
        } else if (totalValue > MAX_DEGREE) {
            this.degree = MAX_DEGREE;
        } else {
            this.degree = totalValue;
        }
    }

    private int innerGetDegree() {
        return degree;
    }

    private String innerMethodGetVersion() {
        return manufacturer + " - " + type + ", v0.01";
    }

}
