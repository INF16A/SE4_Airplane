public class Lavatory implements ILavatory {
    private String manufacturer;
    private String type;
    private String id;
    private boolean isLocked;
    private boolean isCleaned;

    public Lavatory() {
        manufacturer = "INF16B";
        type = "A good one";
        id = "1";
    }

    public String version() {
        return "Lavatory 1.0";
    }

    public boolean lock() {
        if(isLocked == true)
            return false;

        isLocked = true;
        return true;
    }

    public boolean unlock() {
        if(isLocked == false)
            return false;

        isLocked = true;
        return true;
    }

    public boolean clear() {
        if(isCleaned == true)
            return false;

        isCleaned = true;
        return true;
    }
}
