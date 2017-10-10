package fm;

public class MonkeyFigureGenerator extends FigureGenerator{

	@Override
	protected Figure makeAnimal() {
		return new MonkeyFigure();
	}

	@Override
	protected Figure makeEnvironment() {
		return new SunFigure();
	}

}

