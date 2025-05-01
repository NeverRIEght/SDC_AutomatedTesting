package dev.mkomarov.homework2;

import dev.mkomarov.homework2.model.Circle;
import dev.mkomarov.homework2.service.IntersectionsFinderService;

import java.util.Scanner;

class Main {
    private static final IntersectionsFinderService INTERSECTIONS_SERVICE = new IntersectionsFinderService();

    public static void main(String[] args) {
        try (Scanner userInput = new Scanner(System.in)) {
            System.out.print("Enter x1 (x value of the first circle center point):");
            int x1 = userInput.nextInt();
            System.out.print("Enter r1 (radius of the first circle):");
            int r1 = userInput.nextInt();
            System.out.print("Enter x2 (x value of the second circle center point):");
            int x2 = userInput.nextInt();
            System.out.print("Enter r1 (radius of the second circle):");
            int r2 = userInput.nextInt();

            if (r1 <= 0 || r2 <= 0) {
                System.out.println("Radii cannot be <= zero");
                System.exit(1);
            }

            int commonYValue = 0;
            Circle circle1 = new Circle(x1, commonYValue, r1);
            Circle circle2 = new Circle(x2, commonYValue, r2);

            int intersectionsCount = INTERSECTIONS_SERVICE.getIntersectionCount(circle1, circle2);

            System.out.printf("Intersections count: %d", intersectionsCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}