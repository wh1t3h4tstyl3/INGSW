package ingsw.state;

import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

public class ImageProvider {
		private static Map<Integer, ImageIcon> GIFs;
		private static ImageProvider instance;
		
		public static ImageProvider getInstance() {
			if(instance == null)
				instance = new ImageProvider();
			return instance;
		}
		
		static {
			GIFs = new HashMap<>();
		}
		
		private ImageProvider() {
		}
		
		public ImageIcon getGIF(int id) {
			ImageIcon gif = GIFs.get(id);
			if(gif == null) {
				switch (id) {
				case 0:
					GIFs.put(id, gif = new ImageIcon("assets/ups-4.gif"));
					break;
				case 1:
					GIFs.put(id, gif = new ImageIcon("assets/ups-1.gif"));
					break;
				case 2:
					GIFs.put(id, gif = new ImageIcon("assets/ups-2.gif"));
					break;
				case 3:
					GIFs.put(id, gif = new ImageIcon("assets/ups-5.gif"));
					break;	
				default:
					break;
				}
			}
			return gif;
		}

}
