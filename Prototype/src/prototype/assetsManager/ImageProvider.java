package prototype.assetsManager;

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
			images.put("BMW", ImageIO.read(new File("images/logoBMW.png")));
			images.put("FIAT", ImageIO.read(new File("images/logoFiat.png")));
			images.put("CITROEN", ImageIO.read(new File("images/logoCitroen.png")));
			images.put("BMWUtilitaria1", ImageIO.read(new File("images/BMWUtilitaria1.png")));
			images.put("BMWBerlina1", ImageIO.read(new File("images/BMWBerlina1.png")));
			images.put("BMWBerlina2", ImageIO.read(new File("images/BMWBerlina2.png")));
			images.put("BMWSuv1", ImageIO.read(new File("images/BMWSuv1.png")));
			images.put("BMWSuv2", ImageIO.read(new File("images/BMWSuv2.png")));
			images.put("CITROENUtilitaria1", ImageIO.read(new File("images/CITROENUtilitaria1.png")));
			images.put("CITROENUtilitaria2", ImageIO.read(new File("images/CITROENUtilitaria2.png")));
			images.put("CITROENUtilitaria3", ImageIO.read(new File("images/CITROENUtilitaria3.png")));
			images.put("CITROENBerlina1", ImageIO.read(new File("images/CITROENBerlina1.png")));
			images.put("CITROENBerlina2", ImageIO.read(new File("images/CITROENBerlina2.png")));
			images.put("CITROENSuv1", ImageIO.read(new File("images/CITROENSuv1.png")));
			images.put("CITROENSuv2", ImageIO.read(new File("images/CITROENSuv2.png")));
			images.put("FIATUtilitaria1", ImageIO.read(new File("images/FIATUtilitaria1.png")));
			images.put("FIATUtilitaria2", ImageIO.read(new File("images/FIATUtilitaria2.png")));
			images.put("FIATUtilitaria3", ImageIO.read(new File("images/FIATUtilitaria3.png")));
			images.put("FIATBerlina1", ImageIO.read(new File("images/FIATBerlina1.png")));
			images.put("FIATBerlina2", ImageIO.read(new File("images/FIATBerlina2.png")));
			images.put("FIATSuv1", ImageIO.read(new File("images/FIATSuv1.png")));
			images.put("FIATSuv2", ImageIO.read(new File("images/FIATSuv2.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage getImage(String image) {
		return images.get(image);
	}
	
	
	
}
