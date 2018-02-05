public interface ILavatory {
    String version();

    boolean lock();

    boolean unlock();

    boolean clear();
}
