
public class Point3D {
	private double x;
	private double y;
	private double z;
	
	Point3D(double i, double j,double k){
		x=i;
		y=j;
		z=k;
	}
	
	public String toString(){
		return "  vertex " + x + " " + y + " " + z + " "+  "\n"; 
	}
}
