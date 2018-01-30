/**
 * Created by Lenovo on 30.01.2018.
 */
public interface IEngine {
    public String vision();
    public boolean start();
    public int increaseRPM(int value);
    public int decreaseRPM(int value);
    public boolean shutdown();
    public void extinguishFire();
}
