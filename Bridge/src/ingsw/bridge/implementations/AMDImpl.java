package ingsw.bridge.implementations;

import java.awt.image.BufferedImage;

import ingsw.bridge.assetsmanager.ImageProvider;

public class AMDImpl implements Implementation {

	@Override
	public BufferedImage addCPU() {
		return ImageProvider.getInstance().getImage("AMDCPU");

	}

	@Override
	public BufferedImage addGPU() {
		return ImageProvider.getInstance().getImage("ATIGPU");
	}

	@Override
	public String getSetup() {
		return "powered by AMD core and ATI graphics";
	}

}
