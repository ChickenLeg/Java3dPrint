import java.io.IOException;
import java.util.LinkedList;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Application to create a text STL file for a Cone curve
 * @author      Howard Rosenblum rosenbh@algonquincollege.com
 * @version     1.0              
 */
public class CreateStlCurve {
	private List<List<Point3D>> list;

	/**
	 * Create a matrix of points
	 */
	public void createMatrix()
	{
		// TODO in lab 4, based on createList in PointList 

		//same as lab3 but the maximum locations contain the value (maxX-minX, maxY-minY, getZ(maxX,maxY)
		list = new LinkedList<List<Point3D>>();
		int i1;
		i1=0;
		for(double a=ConeCurve.getMinX();a<=ConeCurve.getMaxX();a+=ConeCurve.getStepSize()) {
			list.add(new LinkedList<Point3D>());
			for(double b=ConeCurve.getMinY();b<=ConeCurve.getMaxY();b+=ConeCurve.getStepSize()) {
				list.get(i1).add(new Point3D(b-ConeCurve.getMinX(), a-ConeCurve.getMinY(), ConeCurve.getZ(a, b)));
			}
			i1++;
		}
	}
	
	/**
	 * Create Solid based on values in matrix
	 * @param name Name of the solid
	 * @return Generated solid
	 */
	public Solid createSolid(String name)
	{
		Solid solid = new Solid(name);
		
		int width=list.size()-1;
		int height=list.get(0).size()-1;

		// Create curve
		for(int h=0; h<height; h++)
		{
			for(int w=0; w<width; w++)
			{
				// as viewed from above
				solid.addFacet(
						list.get(w).get(h),    // bottom left
						list.get(w+1).get(h),  // bottom right
						list.get(w+1).get(h+1),// top right
						list.get(w).get(h+1)); // top left
			}
		}
		
		// Create bottom edge
		// TODO in lab 5

		// Create top edge
		// TODO in lab 5

		// Create left edge
		// TODO in lab 5

		// Create right edge
		// TODO in lab 5

		// Create base
		// TODO in lab 5

		
		return solid;
	}

	/**
	 * Print the points to the console
	 */
	public void printMatrix()
	{
		for(List<Point3D> row : list)
		{
			for(Point3D value : row)
				System.out.print("("+value+") ");
			System.out.println();
		}
	}
	
	/**
	 * Application main
	 * @param arg Commandline argument (not used)
	 */
	public static void main(String[] arg)
	{
		CreateStlCurve curve = new CreateStlCurve();
		curve.createMatrix();
		Solid solid = curve.createSolid("ConeCurve");
		
		String name = "c:\\temp\\ConeCurve.stl";
		Path path = Paths.get(name);
		
		try {
			solid.toTextFile(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
