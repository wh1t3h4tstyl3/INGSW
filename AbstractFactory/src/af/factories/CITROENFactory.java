package af.factories;

import java.awt.image.BufferedImage;

import af.assetsManager.ImageProvider;
import af.products.Cars;
import af.products.CITROENSuv;
import af.products.CITROENBerline;
import af.products.CITROENUtilitarie;

public class CITROENFactory implements AbstractFactory {

	@Override
	public Cars makeUtilitarie() {
		return new CITROENUtilitarie();
	}

	@Override
	public Cars makeSuv() {
		return new CITROENSuv();
	}

	@Override
	public Cars makeBerline() {
		return new CITROENBerline();
	}

	@Override
	public BufferedImage makeLogo() {
		return ImageProvider.getInstance().getImage("logoCitroen");
	}

}
