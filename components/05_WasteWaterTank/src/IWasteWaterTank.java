public interface IWasteWaterTank {
	String version();
	boolean lock();
	boolean unlock();
	int add(int amount);
	int pumpOut();
}