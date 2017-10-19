package ingsw.adapter.gui;

import java.awt.Color;

public class FxToAwtColorAdapter extends Color {
	private static final long serialVersionUID = 1L;

	private final javafx.scene.paint.Color color;
	
	public FxToAwtColorAdapter(javafx.scene.paint.Color color) {
		super((float)color.getRed(), (float)color.getGreen(), (float)color.getBlue(), (float)color.getOpacity());
		this.color = color;
	}
	
	@Override
	public Color brighter() {
		float r, g, b, a;
		
		javafx.scene.paint.Color brighter = this.color.brighter();
		r = (float) brighter.getRed();
		g = (float) brighter.getGreen();
		b = (float) brighter.getBlue();
		a = (float) brighter.getOpacity();
		
		return new Color(r, g, b, a);
	}
	
	@Override
	public Color darker() {
		float r, g, b, a;
		
		javafx.scene.paint.Color darker = this.color.darker();
		r = (float) darker.getRed();
		g = (float) darker.getGreen();
		b = (float) darker.getBlue();
		a = (float) darker.getOpacity();
		
		return new Color(r, g, b, a);
	}
	
	
}
