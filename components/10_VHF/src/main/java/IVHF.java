public interface IVHF {

    public String version();
    public boolean on();
    public String[] search();
    public String forwardChannel();
    public String backwardChannel();
    public String selectChannel(String channel);
    public boolean off();
}
