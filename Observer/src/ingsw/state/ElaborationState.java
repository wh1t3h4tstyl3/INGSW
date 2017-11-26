package ingsw.state;

public class ElaborationState implements DispatchState {

	@Override
	public void accept(DispatchManager manager) {
		throw new RuntimeException("Shipment alredy accepted");
	}

	@Override
	public void process(DispatchManager manager) {
		System.out.println("Shipment in working...");
		manager.setElaboration(3000, ImageProvider.getInstance().getGIF(2));
		manager.setStateName("<html><div align='center' color='red'>&nbsp;TRAVELLING<br>&nbsp;STATE</div></html>");
		manager.changeState(StateFactory.getInstance().getState(2));
	}

	@Override
	public void send(DispatchManager manager) {
		throw new RuntimeException("Shipment still working...");
	}

	@Override
	public void delivery(DispatchManager manager) {
		throw new RuntimeException("Shipment still working...");
	}

}
