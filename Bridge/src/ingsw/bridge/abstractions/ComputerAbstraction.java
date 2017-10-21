package ingsw.bridge.abstractions;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import ingsw.bridge.implementations.Implementation;

public abstract class ComputerAbstraction {
	
	protected BufferedImage cpu;
	protected BufferedImage gpu;
	protected BufferedImage brand;
	private Implementation implementation;	
	public abstract void addCpu();
	public abstract void addGpu();
	
	public Implementation getImplementation() {
		return implementation;
	}
	
	public void setImplementation(Implementation implementation) {
		this.implementation = implementation;
	}
	
	public void publish(Graphics g) {
		int x = 683-this.brand.getWidth()/2;
		g.drawImage(this.brand, x - 25, 256, null);
		
		if(this.cpu != null) g.drawImage(this.cpu, x + 25 + this.brand.getWidth(), 274, null);
		if(this.gpu != null) g.drawImage(this.gpu, x + 25 + this.brand.getWidth(), 410, null);
	}
	
	public void removeAll() {
		this.cpu = null;
		this.gpu = null;
	}
}
