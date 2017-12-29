package com.kodilla.patterns.factory;

public class Rectangle implements Shape {
    final String name;
    final double width;
    final double lenght;

    public Rectangle(String name, double width, double lenght) {
        this.name = name;
        this.width = width;
        this.lenght = lenght;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getField() {
        return width * lenght;
    }

    @Override
    public double getCircumference() {
        return 2 * width + 2 * lenght;
    }
}
