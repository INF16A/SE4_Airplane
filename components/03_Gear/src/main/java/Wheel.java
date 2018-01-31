/**
 * Created by Lenovo on 30.01.2018.
 */
public class Wheel {
    private String id;
    private long dateOfManufacture;
    private Brake brake;

    public Wheel(String id, long dateOfManufacture)
    {
        this.id = id;
        this.dateOfManufacture = dateOfManufacture;
    }

    public String getId() {
        return id;
    }

    public long getDateOfManufacture() {
        return dateOfManufacture;
    }

    public Brake getBrake() {
        return brake;
    }

    public void setBrake(Brake brake) {
        this.brake = brake;
    }
}
