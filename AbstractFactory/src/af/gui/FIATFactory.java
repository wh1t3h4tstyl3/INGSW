package af.gui;

public class FIATFactory implements AbstractFactory {

	@Override
	public String makeStringUtilitaria1() {
		return new String("Panda");
	}

	@Override
	public String makeStringUtilitaria2() {
		return new String("500");
	}

	@Override
	public String makeStringUtilitaria3() {
		return new String("Grande Punto");
	}

	@Override
	public String makeStringSuv1() {
		return new String("500X");
	}

	@Override
	public String makeStringSuv2() {
		return new String("Toro");
	}

	@Override
	public String makeStringBerlina1() {
		return new String("Tipo");
	}

	@Override
	public String makeStringBerlina2() {
		return new String("Bravo");
	}

}
