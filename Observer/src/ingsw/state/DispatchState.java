package ingsw.state;

public interface DispatchState {
	public void accept(DispatchManager manager);
	public void process(DispatchManager manager);
	public void send(DispatchManager manager);
	public void delivery(DispatchManager manager);
}
