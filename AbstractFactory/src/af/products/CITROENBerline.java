package af.products;

import java.awt.image.BufferedImage;
import java.util.HashMap;

import af.assetsManager.ImageProvider;

public class CITROENBerline implements Cars {

	private HashMap<Integer, String> nomiBerline;
	private HashMap<Integer, BufferedImage> imagesBerline;
	
	public CITROENBerline() {
		nomiBerline = new HashMap<>();
		imagesBerline = new HashMap<>();
		
		
		nomiBerline.put(new Integer(1), "DS4");
		imagesBerline.put(new Integer(1), ImageProvider.getInstance().getImage("CITROENBerlina1"));
		
		nomiBerline.put(new Integer(2), "C6");
		imagesBerline.put(new Integer(2), ImageProvider.getInstance().getImage("CITROENBerlina2"));
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
