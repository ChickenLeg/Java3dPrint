import java.util.*;
public class Solid {
	private String name;
	private List<Facet> facets;
	private int CurrentSize;
	
	Solid(String n){
		name = n;
		facets = new LinkedList<Facet>();
		CurrentSize = 0;
	}
	
	Solid(){
		facets = new LinkedList<Facet>();
		CurrentSize = 0;
	}
	
	public boolean addFacet(Facet f){
		if (CurrentSize < 4) {
			facets.add(f);
			CurrentSize ++;
		}
		
		return true;
	}
	
	public String toString() {
		return "solid " + name + "\n" + facets.get(0).toString() + facets.get(1).toString() + facets.get(2).toString() + facets.get(3).toString() + "\nendsolid Tetrahedron";	}
	
	
}
