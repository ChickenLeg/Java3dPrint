package stl;
import java.util.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Solid {
	private String name;
	private List<Facet> facets;
	private int CurrentSize;
	
	Solid(String n){
		name = n;
		facets = new LinkedList<Facet>();
		CurrentSize = 0;
	}
	
	public Solid(){
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
	public boolean addFacet(Point3D ...vertex) {
		//varargs(dataType ...arguement)
		
		//we need int type to do the for loop
		//so facet = vertex
		int length = vertex.length;
		if(length >= 3) {
			for(int i = 0; i < length - 2; i++) {
				//3 points- 1 facet
				//5 points- 2 facets
				//i points- i-2 facets
				
				facets.add(new Facet(vertex[0], vertex[i + 1], vertex[i + 2]));
				//create facets and add it to the solid
				
				CurrentSize++;
			}
			return true;
		}
		return false;
	}
	
	//This method store the toString of the Solid to the Path provided. 
	public void toTextFile(Path path) throws IOException{
		//method of how to write text file(lecture 4 exceptions p30)
//		try
//		{
		//message = toString
		//take toString as an arg to display the result
		Files.write(path, Arrays.asList(toString()), Charset.forName("UTF-8"));
//		} catch (IOException e) {
//		System.out.println("Write failed -"+e.getMessage());
//		}
	}
	
	public String toString() {
		//create str to display varargs
		String str =  "solid " + name + "\n";
		for(int i=0;i<CurrentSize;i++) {
			str= str + facets.get(i);
		}
		str = str + "\nendsolid Tetrahedron";
		//return "solid " + name + "\n" + facets.get(0).toString() + facets.get(1).toString() + facets.get(2).toString() + facets.get(3).toString() + "\nendsolid Tetrahedron";	}
		return str;
	}
}
