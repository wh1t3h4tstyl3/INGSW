package af.factories;

import java.awt.image.BufferedImage;

import af.assetsManager.ImageProvider;
import af.products.Cars;
import af.products.FIATUtilitarie;

public class FIATFactory implements AbstractFactory {

	@Override
	public Cars makeUtilitarie() {
		return new FIATUtilitarie();
	}

	@Override
	public String makeStringSuv1() {
		return new String("500X");
	}

	@Override
	public String makeStringSuv2() {
		return new String("Toro");
	}

	@Override
	public String makeStringBerlina1() {
		return new String("Tipo");
	}

	@Override
	public String makeStringBerlina2() {
		return new String("Bravo");
	}

	@Override
	public BufferedImage makeLogo() {
		return ImageProvider.getInstance().getImage("logoFiat");
	}

}
