public interface IGearDoor {

    String version();

    GearDoorType setGearDoorType(String type);

    boolean close();

    boolean lock();

    boolean unlock();

    boolean open();
}
