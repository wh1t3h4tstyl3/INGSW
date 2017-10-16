package bu.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import bu.builders.ScreenThemeBuilder;
import bu.builders.TxtThemeBuilder;
import bu.products.ScreenTheme;
import bu.products.TxtTheme;
import bu.reader.XMLThemeReader;

public class MainScreen extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton view;
	private JButton save;
	
	public MainScreen() {
		super(new GridLayout(2, 1));
		init();
	}

	private void init() {
		setPreferredSize(new Dimension(1366, 768));
		setVisible(true);
		JButton open = new JButton("OPEN THEME");
		open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileFilter(new FileNameExtensionFilter("Theme (*.xml)", "xml"));
				fileChooser.setAcceptAllFileFilterUsed(false);
				fileChooser.setCurrentDirectory(new File("files"));
				File file = null;
				if (fileChooser.showOpenDialog(MainScreen.this) == JFileChooser.APPROVE_OPTION) {
				  file = fileChooser.getSelectedFile();
				}
				MainFrame.file = file;
				if(file != null) {
					save.setEnabled(true);
					view.setEnabled(true);
					MainFrame.frame.setTitle("THEME CONVERTER  ->  " + file.getName());
				}
			}
		});
		
		JPanel panel = new JPanel();
		panel.add(open);
		add(panel);
		
		panel = new JPanel();
		view = new JButton("VIEW");
		view.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				XMLThemeReader tr = new XMLThemeReader();
				ScreenThemeBuilder screenThemeBuilder = new ScreenThemeBuilder();
				
				tr.read(MainFrame.file, screenThemeBuilder);
				
				ScreenTheme screenTheme = screenThemeBuilder.getTheme();
				
				MainFrame.frame.setContentPane(screenTheme);
				MainFrame.frame.invalidate();
				MainFrame.frame.validate();
			}
		});
		view.setEnabled(false);
		panel.add(view);
		save = new JButton("SAVE AS TXT");
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				XMLThemeReader tr = new XMLThemeReader();
				TxtThemeBuilder txtThemeBuilder = new TxtThemeBuilder();
				
				tr.read(MainFrame.file, txtThemeBuilder);
				
				TxtTheme txtTheme = txtThemeBuilder.getTheme();
				File file = null;
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileFilter(new FileNameExtensionFilter("TXT (*.txt)", "txt", "text"));
				fileChooser.setAcceptAllFileFilterUsed(false);
				fileChooser.setCurrentDirectory(new File("files"));
				if (fileChooser.showSaveDialog(MainScreen.this) == JFileChooser.APPROVE_OPTION) {
				  file = fileChooser.getSelectedFile();
				  
				  String file_name = file.toString();
				  if (!file_name.endsWith(".txt")) {
				      file_name += ".txt";
				      file = new File(file_name);
				  }
				  
				  try {
						txtTheme.save(file);
					} catch (IOException error) {
						error.printStackTrace();
					}
				}
				
			}
		});
		save.setEnabled(false);
		panel.add(save);
		add(panel);
		
		
		
	}
}
