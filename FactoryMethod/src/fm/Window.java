package fm;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public Window() {
		
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
					System.exit(0);

			}
		});
		
		setFocusable(true);
		
		add(new Drawer());
		setTitle("Hello Animal!");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		new Window();
	}

}
