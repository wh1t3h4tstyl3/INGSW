package prototype.factories;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

import prototype.assetsManager.ImageProvider;
import prototype.products.BMWBerline;
import prototype.products.BMWSuv;
import prototype.products.BMWUtilitarie;
import prototype.products.CITROENBerline;
import prototype.products.CITROENSuv;
import prototype.products.CITROENUtilitarie;
import prototype.products.Cars;
import prototype.products.FIATBerline;
import prototype.products.FIATSuv;
import prototype.products.FIATUtilitarie;

public class PrototypeFactory {
	
	private static PrototypeFactory instance;
	private static String brand;
	
	public void setBrand(String brand) {
		PrototypeFactory.brand = brand;
	}

	private static HashMap<String, ArrayList<Cars>> prototypes;
	
	public static PrototypeFactory getInstance() {
		if(instance == null) instance = new PrototypeFactory();
		return instance;
	}
	
	private PrototypeFactory() {}
	
	static {
		brand = "BMW";
		prototypes = new HashMap<>();
		
		ArrayList<Cars> cars = new ArrayList<>();
		cars.add(new BMWUtilitarie());
		cars.add(new BMWSuv());
		cars.add(new BMWBerline());
		prototypes.put("BMW", cars);
		
		cars = new ArrayList<>();
		
		cars.add(new CITROENUtilitarie());
		cars.add(new CITROENSuv());
		cars.add(new CITROENBerline());
		prototypes.put("CITROEN", cars);
		
		cars = new ArrayList<>();
		
		cars.add(new FIATUtilitarie());
		cars.add(new FIATSuv());
		cars.add(new FIATBerline());
		prototypes.put("FIAT", cars);
	}
	
	public Cars makeUtilitarie() {
		Cars cars = null;
		try {
			cars = (Cars) prototypes.get(brand).get(0).clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return cars;
	}
	
	public Cars makeSuv() {
		Cars cars = null;
		try {
			cars = (Cars) prototypes.get(brand).get(1).clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return cars;
	}
	
	public Cars makeBerline() {
		Cars cars = null;
		try {
			cars = (Cars) prototypes.get(brand).get(2).clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return cars;
	}
	
	public BufferedImage makeLogo() {
		return ImageProvider.getInstance().getImage(brand);
	}
}
