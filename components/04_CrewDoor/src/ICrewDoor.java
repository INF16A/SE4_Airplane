public interface ICrewDoor {

    String version();

    boolean close();

    boolean lock();

    boolean unlock();

    boolean open();
}
