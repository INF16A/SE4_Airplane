public interface IDeIcingSystem {
    public String version();
    public boolean activate();
    public int deIce(int amount);
    public int refill();
    public boolean deactivate();
}
