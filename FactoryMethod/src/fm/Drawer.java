package fm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Drawer extends JPanel {

	private static final long serialVersionUID = 1L;
	Figure animal;
	Figure environment;	
	
	public Drawer() {
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(1366, 768));
		setVisible(true);
		
		// FM
		FigureGenerator figureGenerator = new RandomFigureGenerator();
		animal = figureGenerator.getAnimal();
		environment = figureGenerator.getEnvironment();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setFont(new Font("Consolas", Font.PLAIN, 20));
		g.setColor(Color.WHITE);
		drawImage(g, animal.getString(), 400, 100);
		
		g.setFont(new Font("Consolas", Font.PLAIN, 10));
		g.setColor(Color.WHITE);
		drawImage(g, environment.getString(), 0, 0);
	
	}
	
	private void drawImage(Graphics g, String image, int x, int y) {
		for(String line : image.split("\n"))
			g.drawString(line, x, y += g.getFontMetrics().getHeight());
	}

}
