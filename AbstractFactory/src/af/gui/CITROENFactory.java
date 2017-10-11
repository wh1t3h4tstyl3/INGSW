package af.gui;

public class CITROENFactory implements AbstractFactory {

	@Override
	public String makeStringUtilitaria1() {
		return new String("C1");
	}

	@Override
	public String makeStringUtilitaria2() {
		return new String("C2");
	}

	@Override
	public String makeStringUtilitaria3() {
		return new String("C3");
	}

	@Override
	public String makeStringSuv1() {
		return new String("C3 AirCross");
	}

	@Override
	public String makeStringSuv2() {
		return new String("C5 AirCross");
	}

	@Override
	public String makeStringBerlina1() {
		return new String("DS4");
	}

	@Override
	public String makeStringBerlina2() {
		return new String("C6");
	}

}
