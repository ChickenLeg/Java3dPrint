package stl;

import java.io.IOException;
import java.util.LinkedList;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
//import java.util.LinkedList;
import java.util.List;

//import curves.ConeCurve;
//import curves.Curve;

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
	//take curve as a parameter and the data type is Curve
	public void createMatrix(Curve curve)
	{
		// TODO in lab 4, based on createList in PointList 

		//same as lab3 but the maximum locations contain the value (maxX-minX, maxY-minY, getZ(maxX,maxY)
		list = new LinkedList<List<Point3D>>();
		int i1;
		i1=0;
		for(double a=curve.getMinX();a<=curve.getMaxX();a+=curve.getStepSize()) {
			list.add(new LinkedList<Point3D>());
			for(double b=curve.getMinY();b<=curve.getMaxY();b+=curve.getStepSize()) {
				list.get(i1).add(new Point3D(b-curve.getMinX(), a-curve.getMinY(), curve.getZ(a, b)));
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
		//create one line
//		new Point3D(0,0,0),
//		new Point3D(1,0,0),
//		list.get(0).get(1),
//		list.get(0).get(0)
		// according to createCurve method order to add points(x,y,z)
		for(int w=0;w<width;w++) {
			solid.addFacet(
					new Point3D(w,height,0),
					new Point3D(w+1,height,0),
					list.get(height).get(w+1),//z
					list.get(height).get(w)//z
					);
		}

		// Create top edge
		// much similar as create bottom, y=0
		for(int w=0;w<width;w++) {
			solid.addFacet(
					new Point3D(w,0,0),
					new Point3D(w+1,0,0),
					list.get(0).get(w+1),
					list.get(0).get(w)
					);
		}
		
		// Create left edge
		// x=0,z=0
		for(int h=0;h<height;h++) {
			solid.addFacet(
					new Point3D(0,h,0),
					new Point3D(0,h+1,0),
					list.get(h+1).get(0),
					list.get(h).get(0)
					);
		}

		// Create right edge
		// z=0
		for(int h=0;h<height;h++) {
			solid.addFacet(
					new Point3D(width,h,0),
					new Point3D(width,h+1,0),
					list.get(h+1).get(width),
					list.get(h).get(width)
					);
		}
		
		
		// Create base
		// 4 points start from normal(0,0,0)
		solid.addFacet(
				new Point3D(0,0,0),
				new Point3D(width,0,0),
				new Point3D(width,height,0),
				new Point3D(0,height,0)
				);
		

		
		return solid;
	}

	private void get(int b) {
		// TODO Auto-generated method stub
		
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
		ConeCurve cu = new ConeCurve();
		curve.createMatrix(cu);
		
		
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
