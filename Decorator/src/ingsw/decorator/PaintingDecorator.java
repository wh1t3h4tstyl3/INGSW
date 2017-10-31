package ingsw.decorator;

import java.awt.Dimension;
import java.awt.Graphics2D;

public abstract class PaintingDecorator implements PaintingComponent {

	protected PaintingComponent decorator;
	private String infoAndPrice;
	int posX, posY;
	
	public PaintingDecorator(PaintingComponent decorator) {
		this.decorator = decorator;
	}

	@Override
	public void drawComponent(Graphics2D g) {
		this.decorator.drawComponent(g);
	}

	@Override
	public PaintingComponent getDecorator() {
		return this.decorator;
	}
	
	public void setInfoAndPrice(String infoAndPrice) {
		this.infoAndPrice = infoAndPrice;
	}
	
	@Override
	public String getInfoAndPrice() {
		return infoAndPrice;
	}
	
	public void resetImage(Dimension d) {
//		int newWidth, newHeight;
//		if(decoration.getWidth(null) > decoration.getHeight(null)) {
//			newWidth = d.width*2/3;
//			newHeight = newWidth*decoration.getHeight(null)/decoration.getWidth(null);
//		}
//		else {
//			newHeight = d.height*2/3;
//			newWidth = newHeight*decoration.getWidth(null)/decoration.getHeight(null);
//		}
//		
//		this.decoration = decoration.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
//		posX = d.width/2 - this.decoration.getWidth(null)/2;
//		posY = d.height/2 - this.decoration.getHeight(null)/2;
		decorator.resetImage(d);
	}
}
