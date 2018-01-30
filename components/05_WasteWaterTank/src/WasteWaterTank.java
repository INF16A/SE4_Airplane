import java.lang.reflect.Method;

public class WasteWaterTank {

	private static WasteWaterTank instance = new WasteWaterTank();
	public Port port;

	private String manufacturer;
	private String id;
	private int capacity;
	private boolean isLocked;
	private int current;

	private WasteWaterTank(){
		capacity = 1000;
		current = 0;
		isLocked = false;
		port = new Port();
	}

	public boolean setIsLocked(boolean toLocked){
		isLocked = toLocked;
		return isLocked;
	}
	public int addCapacity(int amount){
		capacity = capacity + amount;
		return capacity;
	}
	public String toString(){
		return "WasteWaterTank - Version 1.0";
	}

	public static WasteWaterTank getInstance() {
		return instance;
	}
	public class Port implements IWasteWaterTank {
		private Method[] methods = getClass().getMethods();

		public boolean lock(){
			return setIsLocked(true);
		}
		public boolean unlock() {
			return setIsLocked(false);
		}
		public int addCapacity(int amount) {
			return 0;
		}
		public int pumpOut() {
			return 0;
		}
		public String version(){
			return WasteWaterTank.this.toString();
		}
		public void listMethods() {
			System.out.println("--- public methods for " + getClass().getName());
			for (int i = 0; i < methods.length; i++)
			if (!methods[i].toString().contains("Object") && !methods[i].toString().contains("list"))
				System.out.println(methods[i]);
				System.out.println("---");
		}
	}
}
