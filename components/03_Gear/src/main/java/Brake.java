/**
 * Created by Lenovo on 30.01.2018.
 */
public class Brake {
    private String id;
    private long dateOfManufacture;
    private int percentage;


    public Brake(String id, long dateOfManufacture)
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

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

}
