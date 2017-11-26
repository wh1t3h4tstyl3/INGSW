package ingsw.state;

import java.util.HashMap;
import java.util.Map;

public class StateFactory {
	private static Map<Integer, DispatchState> states;
	private static StateFactory instance;
	
	public static StateFactory getInstance() {
		if(instance == null)
			instance = new StateFactory();
		return instance;
	}
	
	static {
		states = new HashMap<>();
	}
	
	private StateFactory() {
	}
	
	public DispatchState getState(int id) {
		DispatchState state = states.get(id);
		if(state == null) {
			switch (id) {
			case 0:
				states.put(id, state = new WaitingState());
				break;
			case 1:
				states.put(id, state = new ElaborationState());
				break;
			case 2:
				states.put(id, state = new TravellingState());
				break;
			case 3:
				states.put(id, state = new DeliveringState());
				break;	
			default:
				break;
			}
		}
		return state;
	}
}
