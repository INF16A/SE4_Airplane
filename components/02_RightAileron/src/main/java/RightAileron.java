public class RightAileron {

    public static final int MAX_DEGREE = 21;
    public static final int MIN_DEGREE = -21;
    private static RightAileron instance = new RightAileron();
    public Port port;
    private String manufacturer;
    private String type;
    private String id;
    private int degree;

    private RightAileron() {
        port = new Port();
    }

    public static RightAileron getInstance() {
        return instance;
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
        public int fullUp() {
            innerSetDegree(MAX_DEGREE);
            return innerGetDegree();
        }

        @Override
        public int fullDown() {
            innerSetDegree(MIN_DEGREE);
            return innerGetDegree();
        }

        @Override
        public int up(int degree) {
            innerAddDegree(degree);
            return innerGetDegree();
        }

        @Override
        public int down(int degree) {
            innerAddDegree(degree * -1);
            return innerGetDegree();
        }
    }

}
