package ingsw.data;

import java.util.LinkedList;
import java.util.List;

public class Capital {
	private String name;
	private List<Place> cities;
	
	public Capital(String name) {
		this.name = name;
		cities = new LinkedList<>();
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return name.equals(((Capital) obj).getName());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Place> getCities() {
		return cities;
	}

	public void setCities(List<Place> city) {
		this.cities = city;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
