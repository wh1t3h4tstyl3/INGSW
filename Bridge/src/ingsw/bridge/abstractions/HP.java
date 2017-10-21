package ingsw.bridge.abstractions;

import java.awt.Graphics;

public class HP extends ComputerAbstraction {

	
	public HP() {
		this.setImplementation(null);
	}
	
	@Override
	public void addCpu() {

	}

	@Override
	public void addGpu() {

	}

	@Override
	public void publish(Graphics g) {
		g.drawImage(this.brand, 200, 500, null);
	}

}
