package af.gui;

public class BMWFactory implements AbstractFactory {

	@Override
	public String makeStringUtilitaria1() {
		return new String("i3");
	}

	@Override
	public String makeStringUtilitaria2() {
		return new String("i3");
	}

	@Override
	public String makeStringUtilitaria3() {
		return new String("i3");
	}

	@Override
	public String makeStringSuv1() {
		return new String("X5");
	}

	@Override
	public String makeStringSuv2() {
		return new String("X6");
	}

	@Override
	public String makeStringBerlina1() {
		return new String("320");
	}

	@Override
	public String makeStringBerlina2() {
		return new String("Serie 5");
	}

}
