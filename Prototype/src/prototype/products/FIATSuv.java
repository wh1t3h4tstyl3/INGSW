package prototype.products;

import java.util.HashMap;

import prototype.assetsManager.ImageProvider;

public class FIATSuv extends Cars {

	public FIATSuv() {
		names = new HashMap<>();
		images = new HashMap<>();
		
		
		names.put(new Integer(1), "500X");
		images.put(new Integer(1), ImageProvider.getInstance().getImage("FIATSuv1"));
		
		names.put(new Integer(2), "Toro");
		images.put(new Integer(2), ImageProvider.getInstance().getImage("FIATSuv2"));
	}
}
