package ingsw.data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CSVParser {
	
	private List<Region> regions;
	
	public CSVParser() {
		this.regions = new ArrayList<>();
	}
	
	public void read(File file) throws IOException {
				
		List<String> tuples = Files.readAllLines(file.toPath());
		
		Iterator<String> it = tuples.iterator();
		
		List<Region> regions = new ArrayList<>();
		
		while(it.hasNext()) {
			String[] values = it.next().split("\"|,");
/*
 * 						   CAP		  Place		  Region	 Capital
 * 	    				values[1]	values[4]	values[9]	values[14]
 */			
	
			Region region = new Region(values[9]);
			if(!regions.contains(region))
				regions.add(region);
			
			Capital capital = new Capital(values[14]);
			for(Region r : regions) {
				if(r.getName().equals(values[9])) {
					if(!r.getRegionalCapital().contains(capital))
						r.getRegionalCapital().add(capital);
					Place place = new Place(values[4]);
					for(Capital c : r.getRegionalCapital()) {
						if(c.getName().equals(values[14])) {
							if(!c.getCities().contains(place))
								c.getCities().add(place);
							break;
						}
					}
					break;
				}
			}			
		}
		
		this.regions = regions;
	}
	
	public String[] getRegionsNames() {
		String[] names = new String[regions.size()+1];
		names[0] = "Scegli una regione...";
		for (int i = 1, j = 0; i < names.length; ++i, ++j) {
			names[i] = regions.get(j).getName();
		}
		return names;
	}

	public String[] getCapitalNames(Object selectedItem) {
		String[] names = null;
		for (Region region : regions)
			if (selectedItem.equals(region.getName())) {
				names = new String[region.getRegionalCapital().size() + 1];
				names[0] = "Scegli un capoluogo...";
				for (int i = 1, j = 0; j < region.getRegionalCapital().size(); ++i, ++j)
					names[i] = region.getRegionalCapital().get(j).getName();
				break;
			}
		return names;
	}
	
	public String[] getPlacesNames(Object regionName, Object capitalName) {
		String[] names = null;
		
		for(Region region : regions)
			if(regionName.equals(region.getName())) { 
				for (Capital capital : region.getRegionalCapital())
					if(capitalName.equals(capital.getName())) {				
						names = new String[capital.getCities().size() + 1];
						names[0] = "Scegli una città...";
						for (int i = 1, j = 0; j < capital.getCities().size(); ++i, ++j)
							names[i] = capital.getCities().get(j).getName();
						break;
					}
				break;
			}
		return names;
	}
}
