package ingsw.bridge.implementations;

import java.awt.image.BufferedImage;

import ingsw.bridge.assetsmanager.ImageProvider;

public class IntelNvidiaImpl implements Implementation {

	@Override
	public BufferedImage addCPU() {
		return ImageProvider.getInstance().getImage("IntelCPU");
	}

	@Override
	public BufferedImage addGPU() {
		return ImageProvider.getInstance().getImage("NvidiaGPU");
	}

	@Override
	public String getSetup() {
		return "powered by Intel core and Nvidia graphics";
	}

}
