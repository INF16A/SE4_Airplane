/**
 * Created by Lenovo on 30.01.2018.
 */
public interface IHydraulicPump {
    public String version();
    public int compress();
    public int compress(int amount);
    public int decompress();
    public int refilOil();
    public int refillOil(int amount);
}
