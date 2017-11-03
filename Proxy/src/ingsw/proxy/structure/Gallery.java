package ingsw.proxy.structure;

import java.awt.Dimension;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Gallery implements AbstractGallery{
	
	private List<ImageWrapped> collection;
	private ListIterator<ImageWrapped> it;
	private ImageWrapped currentImage;
	
	public Gallery(Dimension screenSize) {
		initGallery(screenSize);
	}
	
	private void initGallery(Dimension screenSize) {
		
		currentImage = null;
		collection = new LinkedList<>();
		
		Object[] options = {"Yes", "No"};
		int selection = JOptionPane.showOptionDialog(null,
		    "Do you want Fast Loading?",
		    "Select type of loading",
		    JOptionPane.YES_NO_OPTION,
		    JOptionPane.QUESTION_MESSAGE,
		    null,
		    options,
		    options[1]);
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.setDialogTitle("Select your images folder...");
		fileChooser.setCurrentDirectory(new File("."));
		
		File folder = null;
		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		  folder = fileChooser.getSelectedFile();
		}
		else
			System.exit(0);
		
		File[] fileNames = folder.listFiles();
		
		ImageWrapped im = null;
		for (int i = 1; i < fileNames.length; i++) {
			System.out.println(i + " " + fileNames[i]);
			if(fileNames[i].getName().endsWith("jpg") ||
					fileNames[i].getName().endsWith("png")) {
				if(selection == 1) {
					im = new Image(fileNames[i].getAbsolutePath(), screenSize);
				}
				else
					im = new ImageProxy(fileNames[i].getAbsolutePath(), screenSize);
				collection.add(im);
			}
		}
		
		it = collection.listIterator();
		if(it.hasNext())
			currentImage = it.next();
	}
	
	public void next() {
		if(!it.hasNext())
			it = collection.listIterator(0);
		
		ImageWrapped tmp = it.next();
		
		// check necessary if the last command was prev
		if(tmp == currentImage) {
			if(!it.hasNext())
				it = collection.listIterator(0);
			tmp = it.next();
		}
		
		currentImage = tmp;
	}
	
	public void prev() {
		if(!it.hasPrevious())
			it = collection.listIterator(collection.size());
		
		ImageWrapped tmp = it.previous();
		
		// check necessary if the last command was next
		if(tmp == currentImage) {
			if(!it.hasPrevious())
				it = collection.listIterator(collection.size());
			tmp = it.previous();
		}
		
		currentImage = tmp;
	}

	public ListIterator<ImageWrapped> getIterator() {
		return it;
	}

	public ImageWrapped getCurrentImage() {
		return currentImage;
	}
	
	public boolean isEmpty() {
		return collection.isEmpty();
	}

	public void showPath() {
		//Custom button text
		Object[] options = {"OK"};
		JOptionPane.showOptionDialog(null,
		    currentImage.getPath(),
		    "Path",
		    JOptionPane.OK_OPTION,
		    JOptionPane.INFORMATION_MESSAGE,
		    null,
		    options,
		    options[0]);
	}
	
	public void remove() {
		it.remove();
		next();
	}
}
