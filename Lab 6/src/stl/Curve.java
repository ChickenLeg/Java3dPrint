package stl;

public interface Curve {
	//Get all methods from ConeCurve
	public double getMinX();
	public double getMinY();
	public double getMaxX();
	public double getMaxY();
	
	public double getStepSize();
	
	public double getZ(double x,double y) ;
}
