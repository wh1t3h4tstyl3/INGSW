package ingsw.bridge.abstractions;

import ingsw.bridge.assetsmanager.ImageProvider;

public class Asus extends ComputerAbstraction {

	
	public Asus() {
		this.setImplementation(null);
		this.cpu = null;
		this.gpu = null;
		this.brand = ImageProvider.getInstance().getImage("Asus");
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
