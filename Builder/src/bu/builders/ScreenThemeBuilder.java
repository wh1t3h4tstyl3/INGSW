package bu.builders;

import bu.products.ScreenTheme;

public class ScreenThemeBuilder extends ThemeBuilder {
	
	ScreenTheme screenTheme;
	
	public ScreenThemeBuilder() {
		screenTheme = new ScreenTheme();
	}
	
	@Override
	public void convertTitle(String title) {
		screenTheme.setTitle(title);
	}
	
	@Override
	public void convertContent(String content, String color) {
		screenTheme.addContent(content, color);
	}
	
	public ScreenTheme getTheme() {
		return this.screenTheme;
	}
}
