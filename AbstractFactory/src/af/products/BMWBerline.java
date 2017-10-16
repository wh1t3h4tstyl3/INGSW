package af.products;

import java.awt.image.BufferedImage;
import java.util.HashMap;

import af.assetsManager.ImageProvider;

public class BMWBerline implements Cars {

	private HashMap<Integer, String> nomiBerline;
	private HashMap<Integer, BufferedImage> imagesBerline;
	
	public BMWBerline() {
		nomiBerline = new HashMap<>();
		imagesBerline = new HashMap<>();
		
		
		nomiBerline.put(new Integer(1), "320");
		imagesBerline.put(new Integer(1), ImageProvider.getInstance().getImage("BMWBerlina1"));
		
		nomiBerline.put(new Integer(2), "Serie 5");
		imagesBerline.put(new Integer(2), ImageProvider.getInstance().getImage("BMWBerlina2"));
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
