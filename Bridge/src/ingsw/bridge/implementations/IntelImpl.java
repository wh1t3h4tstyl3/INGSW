package ingsw.bridge.implementations;

import java.awt.image.BufferedImage;

import ingsw.bridge.assetsmanager.ImageProvider;

public class IntelImpl implements Implementation {

	@Override
	public BufferedImage addCPU() {
		return ImageProvider.getInstance().getImage("IntelCPU");

	}

	@Override
	public BufferedImage addGPU() {
		return ImageProvider.getInstance().getImage("IntelGPU");
	}

	@Override
	public String getSetup() {
		return "powered by Intel core and Intel graphics";
	}
}
