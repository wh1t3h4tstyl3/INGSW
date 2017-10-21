package ingsw.bridge.assetsmanager;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class ImageProvider {
	private static HashMap<String, BufferedImage> images;
	private static ImageProvider instance;
	
	public static ImageProvider getInstance() {
		if(instance == null) instance = new ImageProvider();
		return instance;
	}
		
	private ImageProvider() {
		images = new HashMap<>();
		try {
			images.put("Asus", ImageIO.read(new File("images/Asus.png")));
			images.put("Dell", ImageIO.read(new File("images/Dell.png")));
			images.put("HP", ImageIO.read(new File("images/HP.png")));
			images.put("IntelCPU", ImageIO.read(new File("images/IntelCPU.png")));
			images.put("IntelGPU", ImageIO.read(new File("images/IntelGPU.png")));
			images.put("AMDCPU", ImageIO.read(new File("images/AMDCPU.png")));
			images.put("ATIGPU", ImageIO.read(new File("images/ATIGPU.png")));
			images.put("NvidiaGPU", ImageIO.read(new File("images/NvidiaGPU.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage getImage(String image) {
		return images.get(image);
	}
	
	
	
}
