package stl;

import java.io.IOException;
import java.util.LinkedList;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
//import java.util.LinkedList;
import java.util.List;

import curves.ConeCurve;

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
		double xSize = (curve.getMaxX() - curve.getMinX()) / curve.getStepSize() + 1;
		double ySize = (curve.getMaxY() - curve.getMinY()) / curve.getStepSize() + 1;
		double ss = curve.getStepSize();
		for(int i = 0 ; i < ySize; i++) {
			list.add(new LinkedList<Point3D>());
			for(int j = 0; j < xSize; j++) {
				list.get(i).add(new Point3D(j * ss, i * ss, curve.getZ(j * ss + curve.getMinX(), i * ss + curve.getMinY())));
			}
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
		double max = list.get(0).get(width).getX();
		double ss = max/width;

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
		double t = 0;
		for(int h=0;h<height;h++) {
			solid.addFacet(
					new Point3D(t,0,0),
					new Point3D(t+ss,0,0),
					list.get(0).get(h+1),
					list.get(0).get(h)
					);
			t+=ss;
		}

		// Create top edge
		// much similar as create bottom, y=0

		t = 0;
		for(int h=0;h<height;h++) {
			solid.addFacet(
					new Point3D(t,width*ss,0),
					new Point3D(t+ss,width*ss,0),
					list.get(width).get(h+1),
					list.get(width).get(h)
					);
			t+=ss;
		}
		
		// Create left edge
		t = 0;
		for(int w=0;w<width;w++) {
			solid.addFacet(
					new Point3D(0,t,0),
					new Point3D(0,t+ss,0),
					list.get(w+1).get(0),
					list.get(w).get(0)
					);
			t+=ss;
		}

		// Create right edge
		t = 0;
		for(int w=0;w<width;w++) {
			solid.addFacet(
					new Point3D(height*ss,t,0),
					new Point3D(height*ss,t+ss,0),
					list.get(w+1).get(height),
					list.get(w).get(height)
					);
			t+=ss;
		}
		
		
		// Create base
		// 4 points start from normal(0,0,0)
		solid.addFacet(
				new Point3D(0,0,0),
				new Point3D(height*ss,0,0),
				new Point3D(height*ss,width*ss,0),
				new Point3D(0,width*ss,0)
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
