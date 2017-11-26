package ingsw.observer;

import java.util.LinkedList;

public class Product {
	private Type type;
	private String name;
	private String model;
	private double price;
	private static int counter;
	private LinkedList<Integer> IDs;

	static {
		counter = 0;
	}
	
	public Product() {
		this.type = Type.NONE;
		this.name = "PROVA";
		this.model = "PROVA";
		this.price = 0;
		this.IDs = new LinkedList<>();
	}
	
	public Product(Type type, String name, String model, double price, int amount) {
		this.type = type;
		this.name = name;
		this.model = model;
		this.price = price;
		this.IDs = new LinkedList<>(); 
		add(amount);
	}
	
	@Override
	public String toString() {
		return name + " " + model + " (" + IDs.size() + " in Stock) > " + price + " €"; 
	}

	public Type getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public String getModel() {
		return model;
	}

	public double getPrice() {
		return price;
	}
	
	public int getAmount() {
		return IDs.size();
	}
	
	public void add(int quantity) {
		while(quantity-- > 0) {
			this.IDs.add(++Product.counter);
		}
	}
	
	
	
	public void setType(Type type) {
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public LinkedList<Integer> getIDs() {
		return IDs;
	}

	@Override
	public boolean equals(Object obj) {
		String internalName = this.getName().toLowerCase();
		String externalName = ((Product)obj).getName().toLowerCase();
		String internalModel = this.getModel().toLowerCase();
		String externalModel = ((Product)obj).getModel().toLowerCase();
		return internalName.equals(externalName) && internalModel.equals(externalModel);
	}
}
