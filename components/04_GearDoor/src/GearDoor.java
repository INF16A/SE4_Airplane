public class GearDoor {

    private static GearDoor Instance = new GearDoor();

    public static GearDoor getInstance()
    {
        return Instance;
    }

    public Port port = new Port();

    private String manufacturer = "Werner";
    private GearDoorType type = null;
    private String id = "103";
    private boolean isClosed;
    private boolean isLocked;

    public class Port implements IGearDoor{

        @Override
        public GearDoorType setGearDoorType(String pType)
        {
            return innerSetGearDoorType(pType);
        }

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

    private GearDoorType innerSetGearDoorType(String pType)
    {
        switch (pType) {
            case "front": type = GearDoorType.front; break;
            case "gear": type = GearDoorType.gear; break;
            default: throw new IllegalArgumentException("Falscher Typ für GearDoor.type weitergegeben");
        }
        return  type;
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
