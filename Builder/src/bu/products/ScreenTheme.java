package bu.products;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import bu.gui.MainFrame;

public class ScreenTheme extends JPanel {

	private String title;
	private ArrayList<String> contentsNames;
	private ArrayList<Color> contentsColors;
	
	private static final long serialVersionUID = 1L;
	
	public ScreenTheme() {
		title = "TITOLO";
		contentsNames = new ArrayList<>();
		contentsColors = new ArrayList<>();
		
		initScreen();
	}
	
	private void initScreen() {
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(1366, 768));
		JButton back = new JButton("BACK");
		setLayout(null);
		back.setBounds(1366 - 150, 768 - 50, 100, 25);
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.frame.setContentPane(MainFrame.mainScreen);
				MainFrame.frame.invalidate();
				MainFrame.frame.validate();
			}
		});
		add(back);
		setVisible(true);
	}
	
	public void setTitle(String title) {
		if(this.title.equals("TITOLO")) this.title = title;
		else this.title = title + " by " + this.title;
	}
	
	public void addContent(String content, String color) {
		contentsNames.add(content);
		contentsColors.add(Color.decode(color));
	}
	
	private int yPos = 50;
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.RED);
		g.setFont(new Font("Consolas", Font.BOLD, 50));
		g.drawString(title, 683 - title.length()*14, yPos);
		
		int yIncrement = yPos + 30;
		for(int i = 0; i < contentsColors.size(); ++i ) {
			g.setColor(contentsColors.get(i));
			g.setFont(new Font("Consolas", Font.PLAIN, 15));
			contentsNames.set(i, contentsNames.get(i) + " -> R:" + contentsColors.get(i).getRed() + 
					" G:" + contentsColors.get(i).getGreen() + " B:" + contentsColors.get(i).getBlue());
			g.drawString(contentsNames.get(i), 683 - contentsNames.get(i).length()*4, yIncrement);
			yIncrement += 15;
		}
	}
	
}
