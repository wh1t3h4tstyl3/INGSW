package ingsw.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ingsw.proxy.structure.AbstractGallery;
import ingsw.utils.Authentication;

public class MainPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private AbstractGallery gallery;

	public MainPanel() {
		super(new BorderLayout());
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		initScreen(screenSize);
		gallery = Authentication.getInstance().getPermission(screenSize);
	}

	private void initScreen(Dimension screenSize) {

		setPreferredSize(screenSize);

		setVisible(true);
		setBackground(Color.BLACK);

		JPanel westPanel = new JPanel(null);
		westPanel.setBackground(Color.BLACK);
		westPanel.setVisible(true);
		westPanel.setPreferredSize(new Dimension(screenSize.width / 10, screenSize.height));

		JPanel southPanel = new JPanel(null);
		southPanel.setBackground(Color.BLACK);
		southPanel.setVisible(true);
		southPanel.setPreferredSize(new Dimension(screenSize.width, screenSize.height / 20));

		int buttonWidth = screenSize.width / 20;
		int buttonHeight = screenSize.height / 40;
		int buttonX = screenSize.width / 2 - buttonWidth * 3 / 2;
		int buttonY = screenSize.height / 40 - buttonHeight / 2;
		JButton button = new JButton("Local Path");
		button.setName("Local Path");
		button.addActionListener(this);
		button.setVisible(true);
		button.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
		southPanel.add(button);

		button = new JButton("Delete");
		button.setName("Delete");
		button.addActionListener(this);
		button.setVisible(true);
		button.setBounds(buttonX + buttonWidth * 3 / 2, buttonY, buttonWidth, buttonHeight);
		southPanel.add(button);

		buttonX = buttonWidth / 2;
		buttonY = screenSize.height / 2 - buttonHeight / 2;
		button = new JButton("Prev");
		button.setName("Prev");
		button.addActionListener(this);
		button.setVisible(true);
		button.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
		westPanel.add(button);

		JPanel eastPanel = new JPanel(null);

		eastPanel.setBackground(Color.BLACK);
		eastPanel.setVisible(true);
		eastPanel.setPreferredSize(new Dimension(screenSize.width / 10, screenSize.height));

		button = new JButton("Next");
		button.setName("Next");
		buttonX = screenSize.width / 20 - buttonWidth / 2;
		buttonY = screenSize.height / 2 - buttonHeight / 2;
		button.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
		button.addActionListener(this);
		button.setVisible(true);
		eastPanel.add(button);

		button = new JButton();
		button.setName("X");
		buttonX = screenSize.width / 20 - buttonWidth / 2;
		buttonY = buttonHeight / 2;
		button.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
		button.setIcon(new ImageIcon("icons/X_icon.png"));
		button.setPressedIcon(new ImageIcon("icons/X_icon_pressed.png"));
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);
		button.setOpaque(false);
		button.addActionListener(this);
		button.setVisible(true);
		eastPanel.add(button);

		add(westPanel, BorderLayout.WEST);
		add(eastPanel, BorderLayout.EAST);
		add(southPanel, BorderLayout.SOUTH);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (gallery.getCurrentImage() != null)
			gallery.getCurrentImage().draw(g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (((JButton) e.getSource()).getName()) {
		case "Prev":
			if (!gallery.isEmpty()) {
				gallery.prev();
				repaint();
			}
			break;
		case "Next":
			if (!gallery.isEmpty()) {
				gallery.next();
				repaint();
			}
			break;
		case "Local Path":
			if (!gallery.isEmpty()) {
				gallery.showPath();
			}
			break;
		case "X":
			Object[] options = { "Yes", "No" };
			int i = JOptionPane.showOptionDialog(null, "Do you want to exit the Gallery?", "Confirm Exit",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
			if (i == 0)
				System.exit(0);
			break;
		case "Delete":
			if (!gallery.isEmpty()) {
				try {
					Object[] optionsE = { "Yes", "No" };
					int selection = JOptionPane.showOptionDialog(null, "Would you delete current image?",
							"Confirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, optionsE,
							optionsE[1]);
					if (selection == 0) {
						gallery.remove();
						repaint();
					}

				} catch (Exception exception) {
					Object[] optionsE = { "Ok" };
					JOptionPane.showOptionDialog(null, exception.getMessage(), "Illegal Operation",
							JOptionPane.ERROR_MESSAGE, JOptionPane.OK_OPTION, null, optionsE, optionsE[0]);
				}
			}
			break;
		default:
			break;
		}
	}
}
