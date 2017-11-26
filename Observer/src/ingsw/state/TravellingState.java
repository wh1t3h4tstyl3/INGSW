package ingsw.state;

public class TravellingState implements DispatchState {

	@Override
	public void accept(DispatchManager manager) {
		throw new RuntimeException("Shipping on the go...");
	}

	@Override
	public void process(DispatchManager manager) {
		throw new RuntimeException("Shipping on the go...");
	}

	@Override
	public void send(DispatchManager manager) {
		System.out.println("The shipment is leaving the warehouse...");
		manager.setElaboration(3000, ImageProvider.getInstance().getGIF(3));
		manager.setStateName("<html><div align='center' color='red'>&nbsp;DELIVERING<br>&nbsp;STATE</div></html>");
		manager.changeState(StateFactory.getInstance().getState(3));
	}

	@Override
	public void delivery(DispatchManager manager) {
		throw new RuntimeException("Shipping on the go...");
	}

}
