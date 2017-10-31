package ingsw.decorator;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FrameDecorator extends PaintingDecorator {
	
	Image frame;
	Image frameOriginal;
	
	public FrameDecorator(PaintingComponent decorator) {
		super(decorator);
		
		try {
			frameOriginal = ImageIO.read(new File("frames/goldFrame1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		resetImage(new Dimension(1366, 768));
	}
	
	@Override
	public void drawComponent(Graphics2D g) {
		super.drawComponent(g);
		g.drawImage(frame, posX, posY, null);
	}
	

	@Override
	public void setImage(BufferedImage painting) {
		Dimension screenSize = new Dimension(1366, 768);
		this.frameOriginal = painting; 
		resetImage(screenSize);
	}
	
	@Override
	public void resetImage(Dimension screenSize) {
		super.resetImage(screenSize);
		int newWidth, newHeight;
//		if(frameOriginal.getWidth(null) > frameOriginal.getHeight(null)) {
//			newWidth = screenSize.width*2/3;
//			newHeight = newWidth*frameOriginal.getHeight(null)/frameOriginal.getWidth(null);
//		}
//		else {
			newHeight = screenSize.height;
			newWidth = newHeight*frameOriginal.getWidth(null)/frameOriginal.getHeight(null);
//		}
		
		this.frame = frameOriginal.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
		posX = screenSize.width/2 - this.frame.getWidth(null)/2;
		posY = screenSize.height/2 - this.frame.getHeight(null)/2;
	}
}
