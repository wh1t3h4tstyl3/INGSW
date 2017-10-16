package prototype.products;

import java.util.HashMap;

import prototype.assetsManager.ImageProvider;

public class CITROENBerline extends Cars {

	
	public CITROENBerline() {
		names = new HashMap<>();
		images = new HashMap<>();
		
		
		names.put(new Integer(1), "DS4");
		images.put(new Integer(1), ImageProvider.getInstance().getImage("CITROENBerlina1"));
		
		names.put(new Integer(2), "C6");
		images.put(new Integer(2), ImageProvider.getInstance().getImage("CITROENBerlina2"));
	}
}
