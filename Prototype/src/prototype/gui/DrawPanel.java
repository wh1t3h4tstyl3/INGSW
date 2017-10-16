package prototype.gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class DrawPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private BufferedImage logo;
	private boolean standard;
	public DrawPanel(BufferedImage logo) {
		this.logo = logo;
		standard = true;
		initWindow();
	}
	
	private void initWindow() {
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(standard) g.drawImage(logo, 683 - logo.getWidth()/2, 0, null);
		else {
			int height = 250;
			int width = 250 * logo.getWidth() / logo.getHeight();
			g.drawImage(logo, 683 - width/2, 0, width, height, null);
		}
	}
	
	public void setLogo(BufferedImage logo, boolean standard) {
		this.logo = logo;
		this.standard = standard;
		repaint();
	}
}
