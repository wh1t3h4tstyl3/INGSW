package ingsw.observer;

public interface Subject {
	public void subscribeObserver(Observer observer);
	public void unSubscribeObserver(Observer observer);
	public void notifyObservers();
}