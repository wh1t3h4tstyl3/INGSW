package af.products;

import java.awt.image.BufferedImage;
import java.util.HashMap;

import af.assetsManager.ImageProvider;

public class CITROENUtilitarie implements Cars {

	private HashMap<Integer, String> nomiUtilitarie;
	private HashMap<Integer, BufferedImage> imagesUtilitarie;

	public CITROENUtilitarie() {
		nomiUtilitarie = new HashMap<>();
		imagesUtilitarie = new HashMap<>();
		
		nomiUtilitarie.put(new Integer(1), "C1");
		imagesUtilitarie.put(new Integer(1), ImageProvider.getInstance().getImage("CITROENUtilitaria1"));
		nomiUtilitarie.put(new Integer(2), "C2");
		imagesUtilitarie.put(new Integer(2), ImageProvider.getInstance().getImage("CITROENUtilitaria2"));
		nomiUtilitarie.put(new Integer(3), "C3");
		imagesUtilitarie.put(new Integer(3), ImageProvider.getInstance().getImage("CITROENUtilitaria3"));
		
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
