package dev.mkomarov.homework2.service;

import dev.mkomarov.homework2.model.Circle;

public class IntersectionsFinderService {

    /**
     * Returns number of intersections between two circles on coordinate pain.
     *
     * @param circle1 first circle
     * @param circle2 second circle
     * @return number of intersection points. In case of an invalid data -1 is returned
     */
    public int getIntersectionCount(Circle circle1, Circle circle2) {
        if (circle1 == null || circle2 == null) {
            throw new NullPointerException("Circle can not be null");
        }

        if (circle1.getRadius() < 0 || circle2.getRadius() < 0) {
            System.out.println("Radii cannot be <= zero, returning -1");
            return -1;
        }

        // Circles are fully identical = infinite number of intersections
        if (circle1.equals(circle2)) {
            return Integer.MAX_VALUE; // int-infinity equivalent
        }

        double distanceBetweenCenters = Math.hypot(
                circle2.getCenterX() - (double) circle1.getCenterX(),
                circle2.getCenterY() - (double) circle1.getCenterY());

        // Centers are identical, radii are different = 0 points
        if (distanceBetweenCenters == 0) {
            return 0;
        }

        double radiiSum = circle1.getRadius() + (double) circle2.getRadius();
        double radiiDiff = Math.abs(circle1.getRadius() - circle2.getRadius());

        if (distanceBetweenCenters < radiiDiff) {
            // One circle inside other without intersections
            return 0;
        } else if (distanceBetweenCenters == radiiDiff) {
            // One circle inside other with one intersection point
            return 1;
        } else if (distanceBetweenCenters == radiiSum) {
            // One circle touches other from outside
            return 1;
        } else if (distanceBetweenCenters > radiiSum) {
            // Distance between centers more than both radii together - no intersection points
            return 0;
        } else {
            // Circles have common area - two intersection points
            return 2;
        }
    }
}
