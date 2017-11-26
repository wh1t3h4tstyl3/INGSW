package ingsw.state;

public class WaitingState implements DispatchState {

	@Override
	public void accept(DispatchManager manager) {
		System.out.println("Shipment accepted");
		manager.setElaboration(3000, ImageProvider.getInstance().getGIF(1));
		manager.setStateName("<html><div align='center' color='red'>ELABORATION<br>STATE</div></html>");
		manager.changeState(StateFactory.getInstance().getState(1));
	}

	@Override
	public void process(DispatchManager manager) {
		throw new RuntimeException("No shipment accepted yet");
	}

	@Override
	public void send(DispatchManager manager) {
		throw new RuntimeException("No shipment accepted yet");
	}

	@Override
	public void delivery(DispatchManager manager) {
		throw new RuntimeException("No shipment accepted yet");
	}

}
