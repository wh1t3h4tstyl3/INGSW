package af.factories;

import java.awt.image.BufferedImage;

import af.assetsManager.ImageProvider;
import af.products.Cars;
import af.products.FIATBerline;
import af.products.FIATSuv;
import af.products.FIATUtilitarie;

public class FIATFactory implements AbstractFactory {

	@Override
	public Cars makeUtilitarie() {
		return new FIATUtilitarie();
	}

	@Override
	public Cars makeSuv() { 
		return new FIATSuv();
	}
	

	@Override
	public Cars makeBerline() {
		return new FIATBerline();
	}

	@Override
	public BufferedImage makeLogo() {
		return ImageProvider.getInstance().getImage("logoFiat");
	}

}
