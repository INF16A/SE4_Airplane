package main.java;

import java.lang.reflect.Method;

public class FuelTank {

	private static FuelTank instance = new FuelTank();
	public Port port;

	private String manufacturer;
	private String id;
	private String type;
	private int amount;
	private int current;

	private FuelTank(){
		port = new Port();
		amount = 250;
		current = 0;
		type = id = "FuelTank";
		manufacturer = "FuelTankManufacturer";
	}

	public int addInner(int toAmount){
		int sum = current + toAmount;
		if(sum > amount){
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
		int sum = current - amount;
		if(sum < 0 ){
			sum = 0;
		}
		current = sum;
		return current;
	}
	public String toString(){
		return "FuelTank - Version 1.0";
	}

	public static FuelTank getInstance() {
		return instance;
	}
	public class Port implements IFuelTank {
		private Method[] methods = getClass().getMethods();
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
			return FuelTank.this.toString();
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
