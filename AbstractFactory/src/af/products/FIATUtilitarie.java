package af.products;

import java.awt.image.BufferedImage;
import java.util.HashMap;

import af.assetsManager.ImageProvider;

public class FIATUtilitarie implements Cars {
	private HashMap<Integer, String> nomiUtilitarie;
	private HashMap<Integer, BufferedImage> imagesUtilitarie;

	public FIATUtilitarie() {
		nomiUtilitarie = new HashMap<>();
		imagesUtilitarie = new HashMap<>();
		
		nomiUtilitarie.put(new Integer(1), "Panda");
		imagesUtilitarie.put(new Integer(1), ImageProvider.getInstance().getImage("BMWUtilitaria1"));
		nomiUtilitarie.put(new Integer(2), "500");
		imagesUtilitarie.put(new Integer(2), ImageProvider.getInstance().getImage("BMWUtilitaria1"));
		nomiUtilitarie.put(new Integer(3), "Grande Punto");
		imagesUtilitarie.put(new Integer(3), ImageProvider.getInstance().getImage("BMWUtilitaria1"));
		
	}

	@Override
	public BufferedImage getImage(int n) {
		return imagesUtilitarie.get(n);
	}

	@Override
	public String getName(int n) {
		return nomiUtilitarie.get(n);
	}

}
