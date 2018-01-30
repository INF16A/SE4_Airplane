/**
 * Created by Lenovo on 30.01.2018.
 */
public class Engine {
    private String manufacturer;
    private String type;
    private String id;
    private boolean isStarted;
    private int rpm;
    private boolean isFire;

    public Port port;
    private Engine instance = new Engine;

    private Engine()
    {
        port = new Port();
    }


    public class Port implements IEngine
    {

    }


}
