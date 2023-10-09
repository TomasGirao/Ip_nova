package Projects.Circle;

import java.util.Scanner;

class Program {
	public static double funcPerimeter(double ray1) {
		return (2 * ray1 * Math.PI);
	}

	public static double funcArea(double ray1) {
		return (ray1 * ray1 * Math.PI);
	}

	public static boolean funcPoint(double circle1[], double point[], double ray1) {
		double distance = Math.pow(point[0] - circle1[0], 2) + Math.pow(point[1] - circle1[1], 2);
		return (distance <= ray1 * ray1);
	}

	public static int funcCircle(double circle1[], double circle2[], double ray1, double ray2) {
    double distance = Math.sqrt(Math.pow(circle2[0] - circle1[0], 2) + Math.pow(circle2[1] - circle1[1], 2));
    if (distance + ray2 <= ray1) {
        return (0);
    }
	else if (distance < ray1 + ray2 && distance > Math.abs(ray1 - ray2)) {
		return (1);
	}
	else
		return (2);
}
	public static void main(String[] args) {
		Scanner data = new Scanner(System.in);
		double	circle1[] = new double[2];
		circle1[0] = data.nextDouble();
		circle1[1] = data.nextDouble();
		double ray1 = data.nextDouble();
		String command = data.next();
		switch (command) {
			case "P":
				System.out.printf("Perimeter: %.2f%n", funcPerimeter(ray1));
				break;
			case "A":
				System.out.printf("Area: %.2f%n", funcArea(ray1));
				break;
			case "LP":
				double point[] = new double[2];
				point[0] = data.nextDouble();
				point[1] = data.nextDouble();
				if (funcPoint(circle1, point, ray1))
					System.out.print("The point belongs to the circle");
				else
					System.out.print("The point does not belong to the circle");
				break;
			case "LC":
				double circle2[] = new double[2];
				circle2[0] = data.nextDouble();
				circle2[1] = data.nextDouble();
				double ray2 = data.nextDouble();
				int result = funcCircle(circle1, circle2, ray1, ray2);
				if (result == 0)
					System.out.print("The first circle cointains the second one");
				else if (result == 1)
					System.out.print("The first circle intersects part of the second one");
				else if (result == 2)
					System.out.print("The first circle does not intersect the second one");
				break;
		}
		data.close();
	}
}
