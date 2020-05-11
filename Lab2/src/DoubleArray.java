
public class DoubleArray {
	static double[][] array;
	
	public static void createArray() {
		int sizeX;
		sizeX = ((int)ConeCurve.getMaxX()-(int)ConeCurve.getMinX())/(int)ConeCurve.getStepSize()+1;
		int sizeY;
		sizeY = ((int)ConeCurve.getMaxY()-(int)ConeCurve.getMinY())/(int)ConeCurve.getStepSize()+1;
		array = new double[sizeX][sizeY];
		
		int i1,j1;
		i1=0;
		for(double i=ConeCurve.getMinX();i<=ConeCurve.getMaxX();i+=ConeCurve.getStepSize()) {
			j1=0;
			for(double j=ConeCurve.getMinY();j<=ConeCurve.getMaxY();j+=ConeCurve.getStepSize()) {
				 array[i1][j1] = ConeCurve.getZ(i, j);
				 j1++;
			}
			i1++;
		}
	}
	
	public static void printArray() {
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[0].length;j++) {
				System.out.printf("%.1f ", array[i][j]);
			}
			System.out.println();
		}
	}
}
