
public class ConeCurve {
	public static double getMinX(){
		 return -10;
	}
	public static double getMinY(){
		 return -10;
	}
	public static double getMaxX(){
		 return 10;
	}
	public static double getMaxY(){
		 return 10;
	}
	
	public static double getStepSize(){
		 return 1;
	}
	
	public static double getZ(double x,double y) {
		return Math.abs(x)+Math.abs(y);
	}
}
