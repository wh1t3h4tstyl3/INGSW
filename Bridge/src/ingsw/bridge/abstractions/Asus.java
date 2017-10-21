package ingsw.bridge.abstractions;

import java.awt.Graphics;

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

	}

	@Override
	public void addGpu() {

	}

	@Override
	public void publish(Graphics g) {
		g.drawImage(this.brand, 200, 500, null);
	}

}
