package fm;

public class SnaleFigureGenerator extends FigureGenerator{

	@Override
	protected Figure makeAnimal() {
		return new SnaleFigure();
	}

	@Override
	protected Figure makeEnvironment() {
		return new MoonFigure();
	}

}
