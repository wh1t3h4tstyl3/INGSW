package ingsw.proxy.structure;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image implements ImageWrapped {
	
	private java.awt.Image image;
	private int posX, posY, titleX, titleY;
	private String path;
	private String name;
	
	public Image(String path, Dimension screenSize) {
		this.posX = this.posY = 0;
		try {
			this.image = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.path = path;
		
		System.out.println(path);
		
		String[] tmp = path.split("\\\\");
		this.name = tmp[tmp.length-1].split("\\.")[0];
		setPosition(screenSize);
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(this.image, posX, posY, null);
		g.setColor(Color.RED);
		g.setFont(new Font("Consolas", Font.PLAIN,25));
		g.drawString(name, titleX, titleY);
	}

	public void setPosition(Dimension screenSize) {
		
		int width = screenSize.width*8/10;
		int height = image.getHeight(null) * width / image.getWidth(null);
		
		this.image = this.image.getScaledInstance(width, height, java.awt.Image.SCALE_FAST);
		
		posX = screenSize.width/2 - width/2;
		posY = screenSize.height/2 - height/2;
		titleX = posX + width/2 - path.length();
		titleY = screenSize.height*4/100;
	}
	
	@Override
	public String getPath() {
		return path;
	}
}
