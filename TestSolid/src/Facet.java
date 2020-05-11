
public class Facet {
	private Point3D normal;
	private Point3D v1;
	private Point3D v2;
	private Point3D v3;
	
	Facet(Point3D k1,Point3D k2,Point3D k3){
		v1=k1;
		v2=k2;
		v3=k3;
		normal = new Point3D(0,0,0);
	}
	
	public String toString() {
		return "facet normal 0.0 0.0 0.0\n outer loop\n" + v1.toString() + v2.toString() + v3.toString() + " endloop\nendfacet\n"; 
	}
}
