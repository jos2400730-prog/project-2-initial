package com.csc205.project2.shapes;
/**
 * AI GENERATION DOCUMENTATION
 * ===========================
 * AI Tool Used: [ChatGpt-5]
 * Generation Date: 10/2/2025
 *
 * Original Prompt:
 * right on with the first guess, the next one will be Cylinder3D.
 * This ones properties will be: radius, and height. also, same rules as before, it needs to
 * Extends Shape3D (which implements ThreeDimensionalShape)
 * Implement the abstract methods from ThreeDimensionalShape
 * Include proper constructors with validation
 * Override toString() with shape-specific formatting
 * Add any shape-specific methods if needed
 *
 * Follow-up Prompts (if any):
 * 1. "[Refinement prompt 1]"
 * 2. "[Refinement prompt 2]"
 *
 * Manual Modifications:
 * - [List any changes you made to the AI output]
 * - [Explain why changes were necessary]
 *
 * Formula Verification:
 * - Volume formula verified against: [The legitimate formula, which it implemented correctly]
 * - Surface area formula verified against: [The legitimate formula, which it implemented correctly]
 */

public class Cylinder3D extends Shape3D {
    private double radius;
    private double height;

    // Constructor
    public Cylinder3D(String name, String color, double radius, double height) {
        super(name, color);
        setRadius(radius);  // use setters for validation
        setHeight(height);
    }

    // Getters and setters with validation
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be greater than zero.");
        }
        this.radius = radius;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be greater than zero.");
        }
        this.height = height;
    }

    // Implement abstract methods from Shape3D
    @Override
    protected double calculateSurfaceArea() {
        return (2 * Math.PI * radius * height) + (2 * Math.PI * Math.pow(radius, 2));
    }

    @Override
    protected double calculateVolume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }

    // Optional shape-specific method
    public double getLateralSurfaceArea() {
        return 2 * Math.PI * radius * height;
    }

    // Override toString for cylinder-specific formatting
    @Override
    public String toString() {
        return "Cylinder [Name=" + getName() +
                ", Color=" + getColor() +
                ", Radius=" + radius +
                ", Height=" + height +
                ", Lateral Surface Area=" + getLateralSurfaceArea() +
                ", Total Surface Area=" + getSurfaceArea() +
                ", Volume=" + getVolume() + "]";
    }
}


