import java.lang.reflect.Method;

public class FirstClassSeat {

    public Port port;
    private static FirstClassSeat instance = new FirstClassSeat();

    private String manifacturer = "Recaro";
    private String type = "FirstClassSeat";
    private String id;
    private Passenger passenger;
    private int level = 0;
    private boolean isSmokingSignOn = false;
    private boolean isSeatBeltSignOn = false;

    private FirstClassSeat(){
        port = new Port();
    }

    public static FirstClassSeat getInstance(){
        return instance;
    }

    public class Port implements IFirstClassSeat {
        private Method[] methods = getClass().getMethods();

        @Override
        public String version() {
            return innerMethodVersion();
        }

        @Override
        public void assign(Passenger passenger) {
            innerMethodAssign(passenger);
        }

        @Override
        public boolean nonSmokingSignOff() {
            return innerMethodNonSmokingSignOff();
        }

        @Override
        public boolean nonSmokingSignOn() {
            return innerMethodNonSmokingSignOn();
        }

        @Override
        public boolean seatBeltOff() {
            return innerMethodSeatBeltOff();
        }

        @Override
        public boolean seatBeltOn() {
            return innerMethodSeatBeltOn();
        }

        @Override
        public boolean readingLightOff() {
            return innerMethodReadingLightOff();
        }

        @Override
        public boolean readingLightOn() {
            return innerMethodReadingLightOn();
        }

        @Override
        public int upRight() {
            return innerMethodUpRight();
        }

        @Override
        public int level1() {
            return innerMethodLevel1();
        }

        @Override
        public int level2() {
            return innerMethodLevel2();
        }

        @Override
        public int level3() {
            return innerMethodLevel3();
        }

        @Override
        public int flat() {
            return innerMethodflat();
        }

        public String getManifacturer(){
            return innerMethodGetManifacturer();
        }
        public String getType(){
            return innerMethodGetType();
        }
        public String getId(){
            return innerMethodGetId();
        }
        public void setId(String id){
            innerMethodSetId(id);
        }
    }

    private String innerMethodVersion(){
        return type + " - " + manifacturer;
    }

    private void innerMethodAssign(Passenger passenger){
        this.passenger = passenger;
    }

    private boolean innerMethodNonSmokingSignOff(){
        isSmokingSignOn = false;
        return isSmokingSignOn;
    }

    private boolean innerMethodNonSmokingSignOn(){
        isSmokingSignOn = true;
        return isSmokingSignOn;
    }

    private boolean innerMethodSeatBeltOff(){
        isSeatBeltSignOn = false;
        return isSeatBeltSignOn;
    }

    private boolean innerMethodSeatBeltOn(){
        isSeatBeltSignOn = true;
        return isSeatBeltSignOn;
    }

    private boolean innerMethodReadingLightOff(){

        return false;
    }

    private boolean innerMethodReadingLightOn(){

        return true;
    }

    private int innerMethodUpRight(){
        return 0;
    }

    private int innerMethodLevel1(){
        return 1;
    }

    private int innerMethodLevel2(){
        return 2;
    }

    private int innerMethodLevel3(){
        return 3;
    }

    private int innerMethodflat(){
        return 9;
    }

    private String innerMethodGetManifacturer(){
        return manifacturer;
    }

    private String innerMethodGetType(){
        return type;
    }

    private String innerMethodGetId(){
        return id;
    }

    private void innerMethodSetId(String id){
        this.id = id;
    }

}
