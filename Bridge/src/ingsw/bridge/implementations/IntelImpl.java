package ingsw.bridge.implementations;

import java.awt.image.BufferedImage;

public class IntelImpl implements Implementation {

	@Override
	public BufferedImage addCPU() {
		return null;

	}

	@Override
	public BufferedImage addGPU() {
		return null;
	}

	@Override
	public String getSetup() {
		return "powered by Intel core and Intel graphics";
	}
}
