package af.products;

import java.awt.image.BufferedImage;
import java.util.HashMap;

import af.assetsManager.ImageProvider;

public class FIATBerline implements Cars {
	
	private HashMap<Integer, String> nomiBerline;
	private HashMap<Integer, BufferedImage> imagesBerline;
	
	public FIATBerline() {
		nomiBerline = new HashMap<>();
		imagesBerline = new HashMap<>();
		
		
		nomiBerline.put(new Integer(1), "Tipo");
		imagesBerline.put(new Integer(1), ImageProvider.getInstance().getImage("FIATBerlina1"));
		
		nomiBerline.put(new Integer(2), "Bravo");
		imagesBerline.put(new Integer(2), ImageProvider.getInstance().getImage("FIATBerlina2"));
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
