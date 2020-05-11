import java.util.*;
public class Solid {
	private String name;
	private Facet[] facets;
	private int CurrentSize;
	
	Solid(String n){
		name = n;
		facets = new Facet[4];
		CurrentSize = 0;
	}
	
	Solid(){
		facets = new Facet[4];
		CurrentSize = 0;
	}
	
	public boolean addFacet(Facet f){
		if (CurrentSize < 4) {
			facets[CurrentSize] = f;
			CurrentSize ++;
		}
		
		return true;
	}
	
	public String toString() {
		return "solid " + name + "\n" + facets[0].toString() + facets[1].toString() + facets[2].toString() + facets[3].toString() + "\nendsolid Tetrahedron"
;	}
	
	
}
