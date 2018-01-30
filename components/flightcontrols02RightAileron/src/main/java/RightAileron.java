
public class RightAileron {

    private static RightAileron instance = new RightAileron();

    public static RightAileron getInstance() {
        return instance;
    }

    public Port port;

    private RightAileron() {
        port = new Port();
    }

    private String manufacturer;
    private String type;
    private String id;
    private int degree;

    public static final int MAX_DEGREE = 21;
    public static final int MIN_DEGREE = -21;

    public class Port implements IRightAileron {

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

        @Override
        public String version() {
            return innerMethodGetVersion();
        }

        @Override
        public int neutral() {
            setDegree(0);
            return getDegree();
        }

        @Override
        public int fullUp() {
            setDegree(MAX_DEGREE);
            return getDegree();
        }

        @Override
        public int fullDown() {
            setDegree(MIN_DEGREE);
            return getDegree();
        }

        @Override
        public int up(int degree) {
            addDegree(degree);
            return getDegree();
        }

        @Override
        public int down(int degree) {
            addDegree(degree * -1);
            return getDegree();
        }
    }

    private void addDegree(int addValue) {
        setDegree(this.degree + addValue);
    }

    private void setDegree(int totalValue) {
        if (totalValue < MIN_DEGREE) {
            this.degree = MIN_DEGREE;
        } else if (totalValue > MAX_DEGREE) {
            this.degree = MAX_DEGREE;
        } else {
            this.degree = totalValue;
        }
    }

    private int getDegree() {
        return degree;
    }

    private String innerMethodGetVersion() {
        return manufacturer + " - " + type + ", v0.01";
    }

}