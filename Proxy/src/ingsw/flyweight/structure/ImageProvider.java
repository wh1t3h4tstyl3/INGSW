package ingsw.flyweight.structure;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

import ingsw.proxy.structure.Image;

public class ImageProvider {
	private static Map<String, Image> images;
	private static ImageProvider instance;
	
	static {
		images = new HashMap<>();
	}
	
	private ImageProvider() {}
	
	public static ImageProvider getInstance() {
		if(instance == null)
			instance = new ImageProvider();
		return instance;
	}
	
	public Image getImage(String imageName) {
		
		Image image = images.get(imageName);
		
		if(image == null)
			images.put(new String(imageName), (image = new Image(imageName, new Dimension())));
		return image;
	}
}
