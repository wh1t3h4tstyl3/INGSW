package ingsw.state;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import ingsw.observer.Observer;
import ingsw.observer.Subject;

public class DispatchManager implements Subject {
	
	private List<Observer> observers;
	private DispatchState state;
	private int elaborationTime;
	private String stateName;
	private ImageIcon gif;
	
	public DispatchManager() {
		this.state = StateFactory.getInstance().getState(0);
		this.stateName = "<html><div align='center' color='green'>&nbsp;&nbsp;WAITING<br>&nbsp;&nbsp;STATE</div></html>";
		observers = new ArrayList<>();
	}
	
	void changeState(DispatchState state) {
		this.state = state;
	}
	
	void setElaboration(int time, ImageIcon gif) {
		elaborationTime = time;
		this.gif = gif;
		notifyObservers();
	}
	
	public void initialize() {
		state.accept(this);
	}
	
	public void work() {
		state.process(this);
	}
	
	public void startShipment() {
		state.send(this);
	}
	
	public void finalize() {
		state.delivery(this);
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

	public int getElaborationTime() {
		return elaborationTime;
	}
	
	public ImageIcon getIcon() {
		return gif;
	}
	
	public void setStateName(String name) {
		this.stateName = name;
	}
	
	public String getStateName() {
		return stateName;
	}

	@Override
	public void notifyObservers() {
		observers.forEach(e -> e.update(this));
	}
}
