package curves;

public class Butterfly implements Curve, stl.Curve {
	public double getMinX() {
		return -16;
	}
	
	public double getMinY() {
		return -10;
	}
	
	public double getMaxX() {
		return 20;
	}
	
	public double getMaxY() {
		return 10;
	} 
	
	public double getStepSize() {
		return 2;
	}
	
	public double getZ(double i, double j) {
		double x=i/2;
		double y=j/2;
		return x+y;
	}

	/**
	 * Name of curve (same as filename)
	 * @return Name of curve
	 */
	public String getName()
	{
		return "Butterfly";
	}
}
