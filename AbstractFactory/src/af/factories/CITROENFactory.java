package af.factories;

import java.awt.image.BufferedImage;

import af.assetsManager.ImageProvider;
import af.products.Cars;
import af.products.CITROENUtilitarie;

public class CITROENFactory implements AbstractFactory {

	@Override
	public Cars makeUtilitarie() {
		return new CITROENUtilitarie();
	}

	@Override
	public String makeStringSuv1() {
		return new String("C3 AirCross");
	}

	@Override
	public String makeStringSuv2() {
		return new String("C5 AirCross");
	}

	@Override
	public String makeStringBerlina1() {
		return new String("DS4");
	}

	@Override
	public String makeStringBerlina2() {
		return new String("C6");
	}

	@Override
	public BufferedImage makeLogo() {
		return ImageProvider.getInstance().getImage("logoCitroen");
	}

}
