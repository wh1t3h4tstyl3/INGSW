package ingsw.decorator;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Painting implements PaintingComponent {
	
	private String infoAndPrice;
	private Image painting;
	private Image paintingOriginal;
	private int posX, posY;
	
	public Painting(BufferedImage painting) {
		this.paintingOriginal = painting;
		setImage(painting);
	}
	
	@Override
	public void drawComponent(Graphics2D g) {
		g.drawImage(painting, posX, posY, null);
	}

	@Override
	public PaintingComponent getDecorator() {
		return null;
	}
	
	@Override
	public String getInfoAndPrice() {
		return infoAndPrice;
	}
	
	public void setInfoAndPrice(String infoAndPrice) {
		this.infoAndPrice = infoAndPrice;
	}

	@Override
	public void setImage(BufferedImage painting) {
		Dimension screenSize = new Dimension(1366, 768);
		this.paintingOriginal = painting; 
//		int newWidth, newHeight; 
//		if(painting.getWidth() > painting.getHeight()) {
//			newWidth = screenSize.width*2/3;
//			newHeight = newWidth*painting.getHeight()/painting.getWidth();
//		}
//		else {
//			newHeight = screenSize.height*2/3;
//			newWidth = newHeight*painting.getWidth()/painting.getHeight();
//		}
//		
//		this.painting = paintingOriginal.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
//		
//		posX = screenSize.width/2 - this.painting.getWidth(null)/2;
//		posY = screenSize.height/2 - this.painting.getHeight(null)/2;
		resetImage(screenSize);
	}
	
	@Override
	public void resetImage(Dimension d) {
		int newWidth, newHeight;
//		if(paintingOriginal.getWidth(null) > paintingOriginal.getHeight(null)) {
//			newWidth = d.width*2/3;
//			newHeight = newWidth*paintingOriginal.getHeight(null)/paintingOriginal.getWidth(null);
//		}
//		else {
			newHeight = d.height*3/4;
			newWidth = newHeight*paintingOriginal.getWidth(null)/paintingOriginal.getHeight(null);
//		}
		
		this.painting = paintingOriginal.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
		posX = d.width/2 - this.painting.getWidth(null)/2;
		posY = d.height/2 - this.painting.getHeight(null)/2;
	}
}
