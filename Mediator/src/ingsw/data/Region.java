package ingsw.data;

import java.util.LinkedList;
import java.util.List;

public class Region {
	private String name;
	private List<Capital> regionalCapital;
	
	public Region(String name) {
		this.name = name;
		regionalCapital = new LinkedList<>();
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return name.equals(((Region) obj).getName());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Capital> getRegionalCapital() {
		return regionalCapital;
	}

	public void setRegionalCapital(List<Capital> regionalCapital) {
		this.regionalCapital = regionalCapital;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
