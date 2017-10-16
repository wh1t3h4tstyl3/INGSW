package af.products;

import java.awt.image.BufferedImage;
import java.util.HashMap;

import af.assetsManager.ImageProvider;

public class BMWSuv implements Cars {

	private HashMap<Integer, String> nomiBerline;
	private HashMap<Integer, BufferedImage> imagesBerline;
	
	public BMWSuv() {
		nomiBerline = new HashMap<>();
		imagesBerline = new HashMap<>();
		
		
		nomiBerline.put(new Integer(1), "X5");
		imagesBerline.put(new Integer(1), ImageProvider.getInstance().getImage("BMWSuv1"));
		
		nomiBerline.put(new Integer(2), "X6");
		imagesBerline.put(new Integer(2), ImageProvider.getInstance().getImage("BMWSuv2"));
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
