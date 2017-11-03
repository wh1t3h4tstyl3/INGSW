package ingsw.proxy.structure;

import java.awt.Dimension;
import java.util.ListIterator;

public class GalleryProxy implements AbstractGallery {
	
	Gallery gallery;
	
	public GalleryProxy(Dimension screenSize) {
		this.gallery = new Gallery(screenSize);
	}
	
	@Override
	public void next() {
		gallery.next();
	}

	@Override
	public void prev() {
		gallery.prev();
	}

	@Override
	public ListIterator<ImageWrapped> getIterator() {
		return gallery.getIterator();
	}

	@Override
	public ImageWrapped getCurrentImage() {
		return gallery.getCurrentImage();
	}

	@Override
	public boolean isEmpty() {
		return gallery.isEmpty();
	}

	@Override
	public void showPath() {
		gallery.showPath();
	}

	@Override
	public void remove() {
		throw new RuntimeException("Illegal operation for simple users");
	}

}
