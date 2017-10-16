package prototype.products;

import java.util.HashMap;

import prototype.assetsManager.ImageProvider;

public class BMWBerline extends Cars {
	
	public BMWBerline() {
		names = new HashMap<>();
		images = new HashMap<>();
		
		
		names.put(new Integer(1), "320");
		images.put(new Integer(1), ImageProvider.getInstance().getImage("BMWBerlina1"));
		
		names.put(new Integer(2), "Serie 5");
		images.put(new Integer(2), ImageProvider.getInstance().getImage("BMWBerlina2"));
	}
}
