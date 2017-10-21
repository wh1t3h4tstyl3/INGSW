package ingsw.bridge.abstractions;

import ingsw.bridge.assetsmanager.ImageProvider;

public class Dell extends ComputerAbstraction {

	
	public Dell() {
		this.setImplementation(null);
		this.cpu = null;
		this.gpu = null;
		this.brand = ImageProvider.getInstance().getImage("Dell");
	}
	
	@Override
	public void addCpu() {
		this.cpu = this.getImplementation().addCPU();
	}

	@Override
	public void addGpu() {
		this.gpu = this.getImplementation().addGPU();
	}
}
