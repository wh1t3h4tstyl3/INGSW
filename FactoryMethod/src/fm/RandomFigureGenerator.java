package fm;

import java.util.Random;

public class RandomFigureGenerator extends FigureGenerator {

	@Override
	protected Figure makeAnimal() {
		Random r = new Random(System.currentTimeMillis());
		int x  = r.nextInt(5);
		switch (x) {
		case 0:
			return new GiraffeFigure();
		case 1:
			return new SnakeFigure();
		case 2:
			return new MonkeyFigure();
		case 3:
			return new SnaleFigure();
		default:
			return new WaleFigure();
		}
	}

	@Override
	protected Figure makeEnvironment() {
		Random r = new Random(System.currentTimeMillis());
		int x  = r.nextInt(2);
		switch (x) {
		case 0:
			return new SunFigure();
		case 1:
			return new MoonFigure();
		default:
			return new WaleFigure();
		}
	}

}
