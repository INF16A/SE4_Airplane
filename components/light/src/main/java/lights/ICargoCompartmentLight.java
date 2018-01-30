package lights;

/**
 * Created by Endrit Callaki on 30.01.2018.
 */
public interface ICargoCompartmentLight {
    public String version();
    public boolean on();
    public void dim();
    public boolean off();
}
