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
	public abstract void publish(Graphics g);
	
	public Implementation getImplementation() {
		return implementation;
	}
	
	public void setImplementation(Implementation implementation) {
		this.implementation = implementation;
	}
	
}
