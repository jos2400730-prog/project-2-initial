package com.csc205.project2.shapes;
/**
 * AI GENERATION DOCUMENTATION
 * ===========================
 * AI Tool Used: [ChatGpt-5]
 * Generation Date: 10/2/2025
 *
 * Original Prompt:
 * all right, were going to do 5 shape classes, one at a time. the first shape will be a sphere, with the property it requires being radius.
 * this class will also need to:
 * Extends Shape3D (which implements ThreeDimensionalShape)
 * Implement the abstract methods from ThreeDimensionalShape
 * Include proper constructors with validation
 * Override toString() with shape-specific formatting
 * Add any shape-specific methods if needed.
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
public class Sphere3D extends Shape3D {
    private double radius;

    // Constructor
    public Sphere3D(String name, String color, double radius) {
        super(name, color);
        setRadius(radius); // use setter for validation
    }

    // Getter and setter with validation
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be greater than zero.");
        }
        this.radius = radius;
    }

    // Implement abstract methods from Shape3D
    @Override
    protected double calculateSurfaceArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    @Override
    protected double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    // Optional shape-specific method
    public double getDiameter() {
        return 2 * radius;
    }

    // Override toString for sphere-specific formatting
    @Override
    public String toString() {
        return "Sphere [Name=" + getName() +
                ", Color=" + getColor() +
                ", Radius=" + radius +
                ", Diameter=" + getDiameter() +
                ", Surface Area=" + getSurfaceArea() +
                ", Volume=" + getVolume() + "]";
    }
}


