package fm;

public class WaleFigureGenerator extends FigureGenerator {

	@Override
	protected Figure makeAnimal() {
		return new WaleFigure();
	}

	@Override
	protected Figure makeEnvironment() {
		return new MoonFigure();
	}
}
