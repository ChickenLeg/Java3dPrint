
public class Facet {
	private Point3D normal;
	private Point3D v1;
	private Point3D v2;
	private Point3D v3;
	
	Facet(Point3D k1,Point3D k2,Point3D k3){
		v1=k1;
		v2=k2;
		v3=k3;
		normal = Point3D.calcNormal(k1, k2, k3);
	}
	
	public String toString() {
		return "facet normal " + normal + " outer loop\n" +"  Vertex " + v1 +"\n  Vertex " + v2 +"\n  Vertex " + v3 + "\n  endloop\nendfacet"; 
	}
}
