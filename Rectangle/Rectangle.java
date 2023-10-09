package Projects.Rectangle;

import java.util.Scanner;

public class Rectangle {
	static double GetAbs(double nb) {
		if (nb < 0)
			return (-nb);
		return (nb);
	}

	static double GetPerimeter(double[] rectangle) {
		double perimeter;
		double x;
		double y;

		x = GetAbs(rectangle[2] - rectangle[0]);
		y = GetAbs(rectangle[3] - rectangle[1]);
		perimeter = x * 2 + y * 2;
		return (perimeter);
	}

	// ERROR !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	static double[] GetHull(double[] rectangle1, double[] rectangle2) {
		double[] hull;
		hull = new double[4];

		if (GetAbs(rectangle1[0]) >= GetAbs(rectangle2[0]))
			hull[0] = rectangle1[0];
		else
			hull[0] = rectangle2[0];
		if (GetAbs(rectangle1[1]) >= GetAbs(rectangle2[1]))
			hull[1] = rectangle1[1];
		else
			hull[1] = rectangle2[1];
		if (GetAbs(rectangle1[2]) >= GetAbs(rectangle2[2]))
			hull[2] = rectangle1[2];
		else
			hull[2] = rectangle2[2];
		if (GetAbs(rectangle1[3]) >= GetAbs(rectangle2[3]))
			hull[3] = rectangle1[3];
		else
			hull[3] = rectangle2[3];
		return (hull);
	}

	static boolean isSquare(double[] rectangle) {
		if (GetAbs(rectangle[0]) == GetAbs(rectangle[1]) && GetAbs(rectangle[0]) == GetAbs(rectangle[2]) && GetAbs(rectangle[0]) == GetAbs(rectangle[3]))
			return (true);
		return (false);
	}

	public static void main(String[] args) {
        Scanner data = new Scanner(System.in);
		double[] rect1;
		double[] rect2;
		rect1 = new double[4];
		rect2 = new double[4];
		rect1[0] = data.nextDouble();
		rect1[1] = data.nextDouble();
		rect1[2] = data.nextDouble();
		rect1[3] = data.nextDouble();
		rect2[0] = data.nextDouble();
		rect2[1] = data.nextDouble();
		rect2[2] = data.nextDouble();
		rect2[3] = data.nextDouble();
		data.close();
		System.out.printf("Perimeter Rect1: %f%n", GetPerimeter(rect1));
		System.out.printf("Perimeter Rect2: %f%n", GetPerimeter(rect2));
		System.out.printf("Perimeter Hull: %f%n", GetPerimeter(GetHull(rect1, rect2)));
		if (isSquare(GetHull(rect1, rect2)))
			System.out.print("It is a SQUARE!!!");
		else
			System.out.print("It is NOT SQUARE!!!");
    }
}
