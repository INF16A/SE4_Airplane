public class CrewDoor{

    private static CrewDoor Instance = new CrewDoor();

    public static CrewDoor getInstance()
    {
        return Instance;
    }

    public Port port = new Port();

    private String manufacturer = "Werner";
    private String type = "Hao Lee";
    private String id = "666";
    private boolean isClosed;
    private boolean isLocked;

    public class Port implements ICrewDoor{

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
}
