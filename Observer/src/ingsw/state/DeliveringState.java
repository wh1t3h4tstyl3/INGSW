package ingsw.state;

public class DeliveringState implements DispatchState {

	@Override
	public void accept(DispatchManager manager) {
		throw new RuntimeException("Shipment on delivery...");
	}

	@Override
	public void process(DispatchManager manager) {
		throw new RuntimeException("Shipment on delivery...");
	}

	@Override
	public void send(DispatchManager manager) {
		throw new RuntimeException("Shipment on delivery...");
	}

	@Override
	public void delivery(DispatchManager manager) {
		System.out.println("Shipment delivered");
		manager.setElaboration(3000, ImageProvider.getInstance().getGIF(0));
		manager.setStateName("<html><div align='center' color='green'>&nbsp;&nbsp;WAITING<br>&nbsp;&nbsp;STATE</div></html>");
		manager.changeState(StateFactory.getInstance().getState(0));
	}

}
