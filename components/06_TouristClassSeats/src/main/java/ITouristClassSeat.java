import dummies.Passenger;

public interface ITouristClassSeat {
    public String version();
    public void assign(Passenger passsenger);
    public boolean nonSmokingSignOff();
    public boolean nonSmokingSignOn();
    public boolean seatBeltOff();
    public boolean seatBeltOn();
    public boolean readingLightOff();
    public boolean readingLightOn();
    public int upRight();
    public int level1();
    public String getManifacturer();
    public String getType();
    public String getId();
    public void setId(String id);
}
