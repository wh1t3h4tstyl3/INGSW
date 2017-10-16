package prototype.products;

import java.awt.image.BufferedImage;
import java.util.HashMap;

public class Cars implements Cloneable {
	protected HashMap<Integer, String> names;
	protected HashMap<Integer, BufferedImage> images;
	
	public HashMap<Integer, BufferedImage> getImages() {
		return images;
	}
	
	public void setImages(HashMap<Integer, BufferedImage> images) {
		this.images = images;
	}
	
	public HashMap<Integer, String> getNames() {
		return names;
	}
	
	public void setNames(HashMap<Integer, String> names) {
		this.names = names;
	}
	
	public BufferedImage getImage(int n) {
		return images.get(n);
	}
	
	public String getName(int n) {
		return names.get(n);
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		Cars car = new Cars();
		HashMap<Integer, String> _names = new HashMap<>();
		HashMap<Integer, BufferedImage> _images = new HashMap<>();
		
		for(Integer i : names.keySet()) {
			_names.put(new Integer(i), new String(names.get(i)));
			_images.put(new Integer(i), images.get(i));
		}
		
		car.setNames(_names);
		car.setImages(_images);
		
		return car;
	}
}
