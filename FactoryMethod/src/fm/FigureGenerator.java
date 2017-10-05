package fm;

public abstract class FigureGenerator {
	
	private Figure animal;
	private Figure environment;
	
	public FigureGenerator() {
		createFigure();
	}
	
	private void createFigure() {
		animal = makeAnimal();
		environment = makeEnvironment();
	}
	
	protected abstract Figure makeAnimal();
	
	protected abstract Figure makeEnvironment();

	public Figure getAnimal() {
		return animal;
	}
	
	public Figure getEnvironment() {
		return environment;
	}
}
