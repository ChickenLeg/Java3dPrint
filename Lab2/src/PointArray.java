
public class PointArray {
	static Point3D[][] array;
	
	public static void createArray() {
		int i;
		int j;
		
		i = ((int)ConeCurve.getMaxX()-(int)ConeCurve.getMinX())/(int)ConeCurve.getStepSize()+1;
		j = ((int)ConeCurve.getMaxY()-(int)ConeCurve.getMinY())/(int)ConeCurve.getStepSize()+1;
		array = new Point3D[i][j];
		
		int i1,j1;
		i1=0;
		for(double a=ConeCurve.getMinX();a<=ConeCurve.getMaxX();a+=ConeCurve.getStepSize()) {
			j1=0;
			for(double b=ConeCurve.getMinY();b<=ConeCurve.getMaxY();b+=ConeCurve.getStepSize()) {
				 array[i1][j1] =new Point3D(b, a, ConeCurve.getZ(a, b));
				 j1++;
			}
			i1++;
		}
	}
	
		public static void printArray() {
			for(int i1=0;i1<array.length;i1++) {
				for(int j1=0;j1<array[0].length;j1++) {
						System.out.print(array[i1][j1]);
				}
				System.out.println();
			}
		}
	} 
