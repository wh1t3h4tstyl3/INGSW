package ingsw.decorator.gui;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import ingsw.decorator.Painting;
import ingsw.decorator.PaintingComponent;

public class MainApp {
	
	public static void createAndShowGUI() throws IOException {
		JFrame frame  = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//PaintingComponent dec = new FrameDecorator( new Painting(ImageIO.read(new File("paintings/Claude_Monet_-_Waterlilies_(Rome).jpg"))));
		PaintingComponent painting = new Painting(ImageIO.read(new File("paintings/Claude_Monet_-_Waterlilies_(Rome).jpg")));
		
		frame.add(new DrawPanel(painting));
		frame.pack();
		frame.setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					createAndShowGUI();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
