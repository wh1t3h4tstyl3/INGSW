package af.factories;

import java.awt.image.BufferedImage;

import af.assetsManager.ImageProvider;
import af.products.BMWUtilitarie;
import af.products.Cars;

public class BMWFactory implements AbstractFactory {

	@Override
	public Cars makeUtilitarie() {
		return new BMWUtilitarie();
	}

	@Override
	public String makeStringSuv1() {
		return new String("X5");
	}

	@Override
	public String makeStringSuv2() {
		return new String("X6");
	}

	@Override
	public String makeStringBerlina1() {
		return new String("320");
	}

	@Override
	public String makeStringBerlina2() {
		return new String("Serie 5");
	}

	@Override
	public BufferedImage makeLogo() {
		return ImageProvider.getInstance().getImage("logoBMW");
	}

}
