package prototype.products;

import java.util.HashMap;

import prototype.assetsManager.ImageProvider;

public class FIATUtilitarie extends Cars {
	
	public FIATUtilitarie() {
		names = new HashMap<>();
		images = new HashMap<>();
		
		names.put(new Integer(1), "Panda");
		images.put(new Integer(1), ImageProvider.getInstance().getImage("FIATUtilitaria1"));
		names.put(new Integer(2), "500");
		images.put(new Integer(2), ImageProvider.getInstance().getImage("FIATUtilitaria2"));
		names.put(new Integer(3), "Grande Punto");
		images.put(new Integer(3), ImageProvider.getInstance().getImage("FIATUtilitaria3"));
	}
}
