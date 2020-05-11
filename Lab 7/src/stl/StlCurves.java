package stl;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import curves.*;

public class StlCurves {

	public static void main(String[] args) {
		List<Curve> curves = new LinkedList<>();
		curves.add(new ConeCurve());
		curves.add(new MonkeySaddle());
		curves.add(new HalfSphere(20.0));
		curves.add(new Butterfly());
		curves.add(new Chopsticks());
		
		System.out.printf("1 ConeCurve\n2 MonkeySaddle\n3 HalfSphere20.0\n4 Butterfly\n5 Chopsticks\nWhich curve number do you want? ");	
		Scanner sca = new Scanner(System.in);
		//take u as user input
		int u = sca.nextInt();
		if (u > 0 && u <= 5) {
			CreateStlCurve curve = new CreateStlCurve();
			//take user input to get LinkedList item
			curve.createMatrix(curves.get(u-1));
			Solid s = new Solid();
			s = curve.createSolid(curves.get(u-1).getName());
			String name = "c:\\temp\\" + curves.get(u-1).getName() + ".stl";
			Path path = Paths.get(name);
			try {
				s.toTextFile(path);
				System.out.printf("c:\\temp\\%s.stl has been created", curves.get(u-1).getName());
			} catch (IOException e) {
				e.printStackTrace();
			}	
		} else {
			System.out.println("Invalid input, no curve created. ");
		}

	}

}
