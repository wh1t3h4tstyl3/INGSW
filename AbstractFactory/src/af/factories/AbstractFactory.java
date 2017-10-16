package af.factories;

import java.awt.image.BufferedImage;

import af.products.Cars;

public interface AbstractFactory {
	public Cars makeUtilitarie();
	public Cars makeSuv();
	public Cars makeBerline();
	public BufferedImage makeLogo();
}
