package ingsw.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store implements Subject {
	private Map<Type, List<Product>> products;
	//private List<String> selled;
	private List<Observer> observers;
	
	public Store() {
		products = new HashMap<>();
//		selled = new ArrayList<>();
		this.observers = new ArrayList<>();
	}
	
	@Override
	public void subscribeObserver(Observer observer) {
		if(!observers.contains(observer))
			observers.add(observer);
	}

	@Override
	public void unSubscribeObserver(Observer observer) {
		observers.remove(observer);
	}
	
	public void addProduct(Product p) {
		if(!products.containsKey(p.getType())) {
			List<Product> list = new ArrayList<>();
			products.put(p.getType(), list);
			products.get(p.getType()).add(p);
		}
		
		else if(!products.get(p.getType()).contains(p))
			products.get(p.getType()).add(p);
		else
			products.get(p.getType()).get(products.get(p.getType()).indexOf(p)).add(p.getAmount());
		
		notifyObservers();
	}
	
	public void removeProduct(Product p, int amount) {
			
		while(--amount >= 0) {
//			int id = p.getIDs().removeLast();
			p.getIDs().removeLast();
//			String product = p.getName() + " " + p.getModel() + " > "  +  p.getPrice() + " euro (" + id + ")";
//			selled.add(product);
		}
		if(p.getAmount() == 0) products.get(p.getType()).remove(p);
		
		notifyObservers();
	}
	
	public Map<Type, List<Product>> getProducts() {
		return products;
	}
	
//	public List<String> getSelled() {
//		return selled;
//	}

	@Override
	public void notifyObservers() {
		observers.forEach(e -> e.update(this));
	}
}
