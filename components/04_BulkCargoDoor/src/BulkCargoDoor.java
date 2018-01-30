public class BulkCargoDoor{

    private static BulkCargoDoor Instance = new BulkCargoDoor();

    public static BulkCargoDoor getInstance()
    {
        return Instance;
    }

    public Port port = new Port();

    private String manufacturer = "Lubitz";
    private String type = "Steiglitzer";
    private String id = "420";
    private boolean isClosed;
    private boolean isLocked;

    public class Port implements IBulkCargoDoor {

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