
public class Point3D {
	private double x;
	private double y;
	private double z;

	Point3D(double i, double j, double k) {
		x = i;
		y = j;
		z = k;
	}

	public String toString() {
		return x + " " + y + " " + z;
	}

	public static Point3D calcNormal(Point3D v1,Point3D v2,Point3D v3) {
		double x, y, z;
		x = ((v2.y-v1.y)*(v3.z-v1.z)-(v2.z-v1.z)*(v3.y-v1.y));
		y = ((v2.z-v1.z)*(v3.x-v1.x)-(v2.x-v1.x)*(v3.z-v1.z));
		z = ((v2.x-v1.x)*(v3.y-v1.y)-(v2.y-v1.y)*(v3.x-v1.x));
		double l = Math.sqrt(x*x + y* y + z * z);
		x /= l;
		y /= l;
		z /= l;
		return new Point3D(x, y, z);
		
	}
}
