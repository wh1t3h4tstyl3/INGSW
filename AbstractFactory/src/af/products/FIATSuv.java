package af.products;

import java.awt.image.BufferedImage;
import java.util.HashMap;

import af.assetsManager.ImageProvider;

public class FIATSuv implements Cars {

	private HashMap<Integer, String> nomiBerline;
	private HashMap<Integer, BufferedImage> imagesBerline;

	public FIATSuv() {
		nomiBerline = new HashMap<>();
		imagesBerline = new HashMap<>();
		
		
		nomiBerline.put(new Integer(1), "500X");
		imagesBerline.put(new Integer(1), ImageProvider.getInstance().getImage("FIATSuv1"));
		
		nomiBerline.put(new Integer(2), "Toro");
		imagesBerline.put(new Integer(2), ImageProvider.getInstance().getImage("FIATSuv2"));
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
