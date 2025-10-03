package com.csc205.project2.shapes;
/**
 * AI GENERATION DOCUMENTATION
 * ===========================
 * AI Tool Used: [ChatGpt-5]
 * Generation Date: 10/2/2025
 *
 * Original Prompt:
 * the next shape will be a Cube3D, with the properties involved being: sideLength. same as with Sphere3D, it needs to:
 * Extend Shape3D (which implements ThreeDimensionalShape)
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

public class Cube3D extends Shape3D {
    private double sideLength;

    // Constructor
    public Cube3D(String name, String color, double sideLength) {
        super(name, color);
        setSideLength(sideLength); // use setter for validation
    }

    // Getter and setter with validation
    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        if (sideLength <= 0) {
            throw new IllegalArgumentException("Side length must be greater than zero.");
        }
        this.sideLength = sideLength;
    }

    // Implement abstract methods from Shape3D
    @Override
    protected double calculateSurfaceArea() {
        return 6 * Math.pow(sideLength, 2);
    }

    @Override
    protected double calculateVolume() {
        return Math.pow(sideLength, 3);
    }

    // Optional shape-specific method
    public double getFaceDiagonal() {
        return sideLength * Math.sqrt(2);
    }

    // Override toString for cube-specific formatting
    @Override
    public String toString() {
        return "Cube [Name=" + getName() +
                ", Color=" + getColor() +
                ", Side Length=" + sideLength +
                ", Face Diagonal=" + getFaceDiagonal() +
                ", Surface Area=" + getSurfaceArea() +
                ", Volume=" + getVolume() + "]";
    }
}

