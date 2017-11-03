package ingsw.utils;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ingsw.proxy.structure.AbstractGallery;
import ingsw.proxy.structure.Gallery;
import ingsw.proxy.structure.GalleryProxy;

public class Authentication {
	private static Authentication instance;
	
	private static Map<String, String> users;
	
	static {
		users = new HashMap<>();
		List<String> list = null; 
		try {
			list = Files.readAllLines(new File("users/credentials").toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		Iterator<String> it = list.iterator(); 
		while(it.hasNext()) {
			String array[] = it.next().split("-");
			users.put(array[0], array[1]);
		}
	}
	
	private Authentication() {}
	
	public static Authentication getInstance() {
		if(instance == null)
			instance = new Authentication();
		return instance;
	}
	
	public AbstractGallery getPermission(Dimension screenSize)  {
		
		JTextField xField = new JTextField();
		JTextField yField = new JPasswordField();

		JPanel myPanel = new JPanel(new GridLayout(4, 1));
		myPanel.add(new JLabel("Username:"));
		myPanel.add(xField);
//		myPanel.add(Box.createVerticalStrut(25)); // a spacer
		myPanel.add(new JLabel("Password:"));
		myPanel.add(yField);

		JOptionPane.showConfirmDialog(null, myPanel, "Please Enter Username and Password",
				JOptionPane.OK_CANCEL_OPTION);
		
		if("Admin".equals(users.get(xField.getText() + "+" + yField.getText())))
			return new Gallery(screenSize);
		
		return new GalleryProxy(screenSize);
	}
}
