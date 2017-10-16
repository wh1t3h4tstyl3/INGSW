package af.products;

import java.awt.image.BufferedImage;
import java.util.HashMap;

import af.assetsManager.ImageProvider;

public class CITROENSuv implements Cars {

	private HashMap<Integer, String> nomiBerline;
	private HashMap<Integer, BufferedImage> imagesBerline;
	
	public CITROENSuv() {
		nomiBerline = new HashMap<>();
		imagesBerline = new HashMap<>();
		
		
		nomiBerline.put(new Integer(1), "C3 AirCross");
		imagesBerline.put(new Integer(1), ImageProvider.getInstance().getImage("CITROENSuv1"));
		
		nomiBerline.put(new Integer(2), "C5 AirCross");
		imagesBerline.put(new Integer(2), ImageProvider.getInstance().getImage("CITROENSuv2"));
	}
	
	@Override
	public BufferedImage getImage(int n) {
		return imagesBerline.get(n);
	}

	@Override
	public String getName(int n) {
		return nomiBerline.get(n);
	}

}
