package ingsw.bridge.abstractions;

import ingsw.bridge.assetsmanager.ImageProvider;

public class HP extends ComputerAbstraction {

	
	public HP() {
		this.setImplementation(null);
		this.cpu = null;
		this.gpu = null;
		this.brand = ImageProvider.getInstance().getImage("HP");
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
