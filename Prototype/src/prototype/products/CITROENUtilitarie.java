package prototype.products;

import java.util.HashMap;

import prototype.assetsManager.ImageProvider;

public class CITROENUtilitarie extends Cars {

	public CITROENUtilitarie() {
		names = new HashMap<>();
		images = new HashMap<>();
		
		names.put(new Integer(1), "C1");
		images.put(new Integer(1), ImageProvider.getInstance().getImage("CITROENUtilitaria1"));
		names.put(new Integer(2), "C2");
		images.put(new Integer(2), ImageProvider.getInstance().getImage("CITROENUtilitaria2"));
		names.put(new Integer(3), "C3");
		images.put(new Integer(3), ImageProvider.getInstance().getImage("CITROENUtilitaria3"));
		
	}
}
