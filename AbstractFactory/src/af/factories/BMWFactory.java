package af.factories;

import java.awt.image.BufferedImage;

import af.assetsManager.ImageProvider;
import af.products.BMWBerline;
import af.products.BMWSuv;
import af.products.BMWUtilitarie;
import af.products.Cars;

public class BMWFactory implements AbstractFactory {

	@Override
	public Cars makeUtilitarie() {
		return new BMWUtilitarie();
	}

	@Override
	public Cars makeSuv() {
		return new BMWSuv();
	}

	@Override
	public Cars makeBerline() {
		return new BMWBerline();
	}

	@Override
	public BufferedImage makeLogo() {
		return ImageProvider.getInstance().getImage("logoBMW");
	}

}
