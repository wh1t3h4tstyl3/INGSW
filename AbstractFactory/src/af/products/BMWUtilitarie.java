package af.products;

import java.awt.image.BufferedImage;
import java.util.HashMap;

import af.assetsManager.ImageProvider;

public class BMWUtilitarie implements Cars {

	private HashMap<Integer, String> nomiUtilitarie;
	private HashMap<Integer, BufferedImage> imagesUtilitarie;

	public BMWUtilitarie() {
		nomiUtilitarie = new HashMap<>();
		imagesUtilitarie = new HashMap<>();
		
		nomiUtilitarie.put(new Integer(1), "i3");
		imagesUtilitarie.put(new Integer(1), ImageProvider.getInstance().getImage("BMWUtilitaria1"));
		
		nomiUtilitarie.put(new Integer(2), "i3");
		imagesUtilitarie.put(new Integer(2), ImageProvider.getInstance().getImage("BMWUtilitaria1"));
		
		nomiUtilitarie.put(new Integer(3), "i3");
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
