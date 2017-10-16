package prototype.products;

import java.util.HashMap;

import prototype.assetsManager.ImageProvider;

public class BMWSuv extends Cars {

	public BMWSuv() {
		names = new HashMap<>();
		images = new HashMap<>();
		
		
		names.put(new Integer(1), "X5");
		images.put(new Integer(1), ImageProvider.getInstance().getImage("BMWSuv1"));
		
		names.put(new Integer(2), "X6");
		images.put(new Integer(2), ImageProvider.getInstance().getImage("BMWSuv2"));
	}
}
