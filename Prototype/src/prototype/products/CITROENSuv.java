package prototype.products;

import java.util.HashMap;

import prototype.assetsManager.ImageProvider;

public class CITROENSuv extends Cars {

	public CITROENSuv() {
		names = new HashMap<>();
		images = new HashMap<>();
		
		
		names.put(new Integer(1), "C3 AirCross");
		images.put(new Integer(1), ImageProvider.getInstance().getImage("CITROENSuv1"));
		
		names.put(new Integer(2), "C5 AirCross");
		images.put(new Integer(2), ImageProvider.getInstance().getImage("CITROENSuv2"));
	}
}
