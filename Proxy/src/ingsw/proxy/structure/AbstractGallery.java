package ingsw.proxy.structure;

import java.util.ListIterator;

public interface AbstractGallery {
	public void next();
	
	public void prev();

	public ListIterator<ImageWrapped> getIterator();

	public ImageWrapped getCurrentImage();
	
	public boolean isEmpty();

	public void showPath();
	
	public void remove();
}
