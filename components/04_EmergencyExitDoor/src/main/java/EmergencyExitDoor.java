public class EmergencyExitDoor{

    private static EmergencyExitDoor Instance = new EmergencyExitDoor();

    public static EmergencyExitDoor getInstance()
    {
        return Instance;
    }

    public Port port = new Port();

    private String manufacturer = "Max Romeo";
    private String type = "Hawk";
    private String id = "1400";
    private boolean isClosed;
    private boolean isLocked;
    private boolean isEscapeSlideActivated = false;

    public class Port implements IEmergencyExitDoor{

        @Override
        public String version()
        {
            return innerVersion();
        }

        @Override
        public boolean close()
        {
            return  innerClose();
        }

        @Override
        public boolean open()
        {
            return  innerOpen();
        }

        @Override
        public boolean lock()
        {
            return  innerLock();
        }

        @Override
        public boolean unlock()
        {
            return  innerUnlock();
        }

        @Override
        public boolean activateEscapeSlide()
        {
            return innerActivateEscapeSlide();
        }
    }

    private String innerVersion()
    {
        return id + " " + type + " " + manufacturer;
    }

    private boolean innerClose()
    {
        isClosed = true;
        return isClosed;
    }

    private boolean innerOpen()
    {
        isClosed = false;
        return isClosed;
    }

    private boolean innerLock()
    {
        isLocked = true;
        return isLocked;
    }

    private boolean innerUnlock()
    {
        isLocked = false;
        return isLocked;
    }

    private boolean innerActivateEscapeSlide()
    {
        isEscapeSlideActivated = true;
        return isEscapeSlideActivated;
    }

}
