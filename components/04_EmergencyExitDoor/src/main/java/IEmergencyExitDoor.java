public interface IEmergencyExitDoor {

    String version();

    boolean close();

    boolean lock();

    boolean unlock();

    boolean open();

    boolean activateEscapeSlide();
}
