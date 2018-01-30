public class AirConditioning implements IAirConditioning {
    private String manufacturer;
    private String type;
    private String id;
    private int temperature;
    private boolean isOn;

    public AirConditioning() {
        temperature = 20;
    }

    public String version() {
        return "AirConditioning 1.0";
    }

    public boolean on() {
        if(isOn == true)
            return false;

        isOn = true;
        return true;
    }

    public String clean(String airFlow) {
        return "Cleaned airflow " + airFlow;
    }

    public String heat(String airFlow, int temperature) {
        this.temperature+=temperature;
        return "Heated airflow " + airFlow + " to " + temperature;
    }

    public String cool(String airFlow, int temperature) {
        this.temperature-=temperature;
        return "cooled airflow " + airFlow + " to " + temperature;
    }

    public boolean off() {
        if(isOn == false)
            return false;

        isOn = false;
        return true;
    }
}
