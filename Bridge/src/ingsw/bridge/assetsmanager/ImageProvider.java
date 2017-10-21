package ingsw.bridge.assetsmanager;

import java.awt.image.BufferedImage;
import java.util.HashMap;

public class ImageProvider {
	private static HashMap<String, BufferedImage> images;
	private static ImageProvider instance;
	
	public static ImageProvider getInstance() {
		if(instance == null) instance = new ImageProvider();
		return instance;
	}
		
	private ImageProvider() {
		images = new HashMap<>();
//		try {
//			images.put("BMW", ImageIO.read(new File("images/logoBMW.png")));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	
	public BufferedImage getImage(String image) {
		return images.get(image);
	}
	
	
	
}
