package af.factories;

import java.awt.image.BufferedImage;

import af.products.Cars;

public interface AbstractFactory {
	public Cars makeUtilitarie();
	public String makeStringSuv1();
	public String makeStringSuv2();
	public String makeStringBerlina1();
	public String makeStringBerlina2();
	public BufferedImage makeLogo();
}
