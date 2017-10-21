package ingsw.bridge.implementations;

import java.awt.image.BufferedImage;

public interface Implementation {
	public BufferedImage addCPU();
	public BufferedImage addGPU();
	public String getSetup();
}
