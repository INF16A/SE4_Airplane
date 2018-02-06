import java.lang.reflect.Method;

public class BusinessClassSeat {

    public Port port;
    private static BusinessClassSeat instance = new BusinessClassSeat();

    private String manifacturer = "Recaro";
    private String type = "BusinessClassSeat";
    private String id;
    private Passenger passenger;
    private int level = 0;
    private boolean isSmokingSignOn = false;
    private boolean isSeatBeltSignOn = false;

    private BusinessClassSeat(){
        port = new Port();
    }

    public static BusinessClassSeat getInstance(){
        return instance;
    }

    public class Port implements IBusinnessClassSeat{

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
