package ingsw.decorator;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public interface PaintingComponent {
	public void drawComponent(Graphics2D g);
	public PaintingComponent getDecorator();
	public String getInfoAndPrice();
	void setImage(BufferedImage image);
	public void resetImage(Dimension d);
}
