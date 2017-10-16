package prototype.products;

import java.util.HashMap;

import prototype.assetsManager.ImageProvider;

public class BMWUtilitarie extends Cars {

	public BMWUtilitarie() {
		names = new HashMap<>();
		images = new HashMap<>();
		
		names.put(new Integer(2), "i3");
		images.put(new Integer(2), ImageProvider.getInstance().getImage("BMWUtilitaria1"));
	}
}
