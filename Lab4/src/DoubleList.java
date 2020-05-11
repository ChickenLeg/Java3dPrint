import java.util.LinkedList;
import java.util.List;



public class DoubleList {
	static List<List<Double>> array;
	
	public static void createList() {
		array = new LinkedList<List<Double>>();

		int i1;
		i1=0;
		for(double i=ConeCurve.getMinX();i<=ConeCurve.getMaxX();i+=ConeCurve.getStepSize()) {
			array.add(new LinkedList<Double>());
			for(double j=ConeCurve.getMinY();j<=ConeCurve.getMaxY();j+=ConeCurve.getStepSize()) {
				array.get(i1).add(ConeCurve.getZ(i, j));
			}
			i1++;
		}
	}
	
	public static void printArray() {
		int sizeX;
		sizeX = ((int)ConeCurve.getMaxX()-(int)ConeCurve.getMinX())/(int)ConeCurve.getStepSize()+1;
		int sizeY;
		sizeY = ((int)ConeCurve.getMaxY()-(int)ConeCurve.getMinY())/(int)ConeCurve.getStepSize()+1;
		for(int i=0;i<sizeX;i++) {
			for(int j=0;j<sizeY;j++) {
				System.out.printf("%.1f ", array.get(i).get(j));
			}
			System.out.println();
		}
	}
}
