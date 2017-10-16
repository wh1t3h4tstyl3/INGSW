package bu.builders;

import bu.products.TxtTheme;

public class TxtThemeBuilder extends ThemeBuilder {
	
	TxtTheme txtTheme;
	
	public TxtThemeBuilder() {
		txtTheme = new TxtTheme();
	}
	
	@Override
	public void convertTitle(String title) {
		txtTheme.setTitle(title);
	}
	
	@Override
	public void convertContent(String content, String color) {
		txtTheme.addContent(content, color);
	}
	
	public TxtTheme getTheme() {
		return this.txtTheme;
	}
}
