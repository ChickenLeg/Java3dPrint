import java.util.LinkedList;
import java.util.List;

public class PointList {
	static List<List<Point3D>> array;
	
	public static void createList() {
		array = new LinkedList<List<Point3D>>();
		
		int i1;
		i1=0;
		for(double a=ConeCurve.getMinX();a<=ConeCurve.getMaxX();a+=ConeCurve.getStepSize()) {
			array.add(new LinkedList<Point3D>());
			for(double b=ConeCurve.getMinY();b<=ConeCurve.getMaxY();b+=ConeCurve.getStepSize()) {
				array.get(i1).add(new Point3D(b, a, ConeCurve.getZ(a, b)));
			}
			i1++;
		}
	}
	
		public static void printArray() {
			int i;
			int j;
			
			i = ((int)ConeCurve.getMaxX()-(int)ConeCurve.getMinX())/(int)ConeCurve.getStepSize()+1;
			j = ((int)ConeCurve.getMaxY()-(int)ConeCurve.getMinY())/(int)ConeCurve.getStepSize()+1;

			for(int i1=0;i1<i;i1++) {
				for(int j1=0;j1<j;j1++) {
						System.out.print("("+array.get(i1).get(j1)+ ") ");
				}
				System.out.println();
			}
		}
	} 
