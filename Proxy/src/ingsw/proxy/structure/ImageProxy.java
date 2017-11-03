package ingsw.proxy.structure;

import java.awt.Dimension;
import java.awt.Graphics;

import ingsw.flyweight.structure.ImageProvider;

public class ImageProxy implements ImageWrapped {
	
	private Image realImage;
	private Dimension screenSize;
	private String path;
	
	public ImageProxy(String path, Dimension screenSize) {
		this.screenSize = screenSize;
		this.path = path;
	}
	
	@Override
	public void draw(Graphics g) {
		getRealImage().draw(g);
	}


	private Image getRealImage() {
		if(this.realImage == null)
			this.realImage = ImageProvider.getInstance().getImage(path, screenSize);
		
		return this.realImage;
	}

	@Override
	public String getPath() {
		return getRealImage().getPath();
	}
}
