package af.assetsManager;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class ImageProvider {
	private HashMap<String, BufferedImage> images;
	private static ImageProvider instance;
	
	public static ImageProvider getInstance() {
		if(instance == null) instance = new ImageProvider();
		return instance;
	}
		
	private ImageProvider() {
		images = new HashMap<>();
		try {
			images.put("logoBMW", ImageIO.read(new File("images/logoBMW.png")));
			images.put("logoFiat", ImageIO.read(new File("images/logoFiat.png")));
			images.put("logoCitroen", ImageIO.read(new File("images/logoCitroen.png")));
			images.put("BMWUtilitaria1", ImageIO.read(new File("images/BMWUtilitaria1.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage getImage(String image) {
		return images.get(image);
	}
	
	
	
}
