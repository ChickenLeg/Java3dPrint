package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import stl.*;

class SolidTest {

	
	@Test
	void testInvalid() {
		//which class is tested
		//create an new object to test
		Solid test = new Solid();
		Solid empty = new Solid();
		
		//cannot add less than 3 point3d in addFacet array
		//thus returns false
		assertFalse(test.addFacet());
		assertFalse(test.addFacet(new Point3D(0, 0, 0)));
		assertFalse(test.addFacet(new Point3D(0, 0, 0), new Point3D(0, 0, 1)));
		
		//to ensure that add 0 facet to a solid
		//if 0 added, then there is no toString printing out
		test.addFacet();
		test.addFacet(new Point3D(0, 0, 0));
		test.addFacet(new Point3D(0, 0, 0), new Point3D(0, 0, 1));
		assertEquals(test.toString(), empty.toString());		
	}
	
	@Test
	void test3() {
		Solid test = new Solid();
		Solid empty = new Solid();
		//create 3 points to be a facet
		Point3D p1 = new Point3D(0, 0, 0);
		Point3D p2 = new Point3D(0, 0, 1);
		Point3D p3 = new Point3D(0, 0, 2);	
		//add one facet to a solid
		assertTrue(test.addFacet(p1, p2, p3));
		Facet f1 = new Facet(p1, p2, p3);
		empty.addFacet(f1);
		assertEquals(test.toString(), empty.toString());
	}
	
	@Test
	void test4() {
		Solid test = new Solid();
		Solid empty = new Solid();
		//create 4 points to make 2 facets
		Point3D p1 = new Point3D(0, 0, 0);
		Point3D p2 = new Point3D(0, 0, 1);
		Point3D p3 = new Point3D(0, 0, 2);	
		Point3D p4 = new Point3D(0, 0, 3);
		//addFacet is an array
		//so we can add p4 right behind it
		assertTrue(test.addFacet(p1, p2, p3, p4));
		Facet f1 = new Facet(p1, p2, p3);
		Facet f2 = new Facet(p1, p3, p4);
		empty.addFacet(f1);
		empty.addFacet(f2);
		assertEquals(test.toString(), empty.toString());
	}
	
	@Test
	void test5() {
		Solid test = new Solid();
		Solid empty = new Solid();
		Point3D p1 = new Point3D(0, 0, 0);
		Point3D p2 = new Point3D(0, 0, 1);
		Point3D p3 = new Point3D(0, 0, 2);	
		Point3D p4 = new Point3D(0, 0, 3);
		Point3D p5 = new Point3D(0, 0, 4);
		assertTrue(test.addFacet(p1, p2, p3, p4, p5));
		Facet f1 = new Facet(p1, p2, p3);
		Facet f2 = new Facet(p1, p3, p4);
		Facet f3 = new Facet(p1, p4, p5);
		empty.addFacet(f1);
		empty.addFacet(f2);
		empty.addFacet(f3);
		assertEquals(test.toString(), empty.toString());
	}

}