package ingsw.bridge.abstractions;

import java.awt.Graphics;

public class Dell extends ComputerAbstraction {

	
	public Dell() {
		this.setImplementation(null);
	}
	
	@Override
	public void addCpu() {
		this.cpu = this.getImplementation().addCPU();
	}

	@Override
	public void addGpu() {
		this.gpu = this.getImplementation().addGPU();
	}

	@Override
	public void publish(Graphics g) {
		g.drawImage(this.brand, 200, 500, null);
	}

}
