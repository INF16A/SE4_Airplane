public interface ICrewSeat {
    public String version();
    public boolean readingLightOn();
    public boolean readingLightOff();
    public String getManifacturer();
    public String getType();
    public String getId();
    public void setId(String id);
}