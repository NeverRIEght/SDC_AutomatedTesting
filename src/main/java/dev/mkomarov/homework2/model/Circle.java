package dev.mkomarov.homework2.model;

import java.util.Objects;

public class Circle {
    private final int centerX;
    private final int centerY;
    private final int radius;

    public Circle(int centerX, int centerY, int radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return centerX == circle.centerX && centerY == circle.centerY && radius == circle.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(centerX, centerY, radius);
    }
}