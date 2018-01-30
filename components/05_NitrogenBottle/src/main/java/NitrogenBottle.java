package main.java;

import java.lang.reflect.Method;

public class NitrogenBottle {

	private static NitrogenBottle instance = new NitrogenBottle();
	public Port port;

	private String manufacturer;
	private String id;
	private String type;
	private int amount;
	private int current;

	private NitrogenBottle(){
		port = new Port();
		amount = 250;
		current = 0;
		type = id = "NitrogenBottleRefill";
		manufacturer = "NitrogenBottleManufacturer";
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
		return "NitrogenBottleRefill - Version 1.0";
	}

	public static NitrogenBottle getInstance() {
		return instance;
	}
	public class Port implements INitrogenBottle {
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
			return NitrogenBottle.this.toString();
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
