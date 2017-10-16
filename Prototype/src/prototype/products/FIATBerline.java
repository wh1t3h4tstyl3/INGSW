package prototype.products;

import java.util.HashMap;

import prototype.assetsManager.ImageProvider;

public class FIATBerline extends Cars {
	
	public FIATBerline() {
		names = new HashMap<>();
		images = new HashMap<>();
		
		
		names.put(new Integer(1), "Tipo");
		images.put(new Integer(1), ImageProvider.getInstance().getImage("FIATBerlina1"));
		
		names.put(new Integer(2), "Bravo");
		images.put(new Integer(2), ImageProvider.getInstance().getImage("FIATBerlina2"));
	}
}
