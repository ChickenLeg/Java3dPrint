
public class PointArrayPractice {
	
	static Point3D[][] array = new Point3D[21][21];
	
	public static void createArray() {
		//array = new Point3D[21][21];
		for(int x=-10;x<11;x+=(int)ConeCurve.getStepSize()) {
			for(int y=-10;y<11;y+=(int)ConeCurve.getStepSize()) {
				array[x+10][y+10] =new Point3D(x, y, ConeCurve.getZ(x, y));
			}
		}
		
		
	}
	public static void printArray() {
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[0].length;j++) {
				System.out.print(array[j][i]);
			}
			System.out.println();
		}
	}
}
