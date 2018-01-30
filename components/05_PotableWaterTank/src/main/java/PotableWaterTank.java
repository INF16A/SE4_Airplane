package main.java;

import java.lang.reflect.Method;

public class PotableWaterTank {

	private static PotableWaterTank instance = new PotableWaterTank();
	public Port port;

	private String manufacturer;
	private String id;
	private String type;
	private int amount;
	private boolean isLocked;
	private int current;

	private PotableWaterTank(){
		port = new Port();
		amount = 1000;
		current = 0;
		isLocked = false;
		type = id = "PotableWaterTank";
		manufacturer = "PotableWaterTankManufacturer";
	}

	public boolean setIsLocked(boolean toLocked){
		isLocked = toLocked;
		return isLocked;
	}
	public int addInner(int toAmount){
		int sum = current + toAmount;
		if(sum > 1000){
			current = amount;
		}else{
			current = sum;
		}
		return current;
	}
	public int fillToHead(){
		current = amount;
		return current;
	}
	public int takeOutInner(int amount){
		int sum = current - 0;
		if(sum < 0 ){
			sum = 0;
		}
		current = sum;
		return current;
	}
	public String toString(){
		return "PotableWaterTank - Version 1.0";
	}

	public static PotableWaterTank getInstance() {
		return instance;
	}
	public class Port implements IPotableWaterTank {
		private Method[] methods = getClass().getMethods();

		public boolean lock(){
			return setIsLocked(true);
		}
		public boolean unlock() {
			return setIsLocked(false);
		}
		public int refill(int amount) {
			return addInner(amount);
		}
		public int refill() {
			return fillToHead();
		}
		public int takeOut(int amount) {
			return takeOutInner(amount);
		}
		public String version(){
			return PotableWaterTank.this.toString();
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
