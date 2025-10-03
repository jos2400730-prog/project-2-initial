package com.csc205.project2.shapes;
/**
 * AI GENERATION DOCUMENTATION
 * ===========================
 * AI Tool Used: [ChatGpt-5]
 * Generation Date: 10/2/2025
 *
 * Original Prompt:
 * Nice, you guessed what I wanted for my last shape. I think SquarePyramid3D is a great last shape!
 * list what properties it needs and follow the rules of
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

public class SquarePyramid3D extends Shape3D {
    private double baseLength;
    private double height;

    // Constructor
    public SquarePyramid3D(String name, String color, double baseLength, double height) {
        super(name, color);
        setBaseLength(baseLength); // use setters for validation
        setHeight(height);
    }

    // Getters and setters with validation
    public double getBaseLength() {
        return baseLength;
    }

    public void setBaseLength(double baseLength) {
        if (baseLength <= 0) {
            throw new IllegalArgumentException("Base length must be greater than zero.");
        }
        this.baseLength = baseLength;
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

    // Helper method: slant height
    public double getSlantHeight() {
        return Math.sqrt(Math.pow(baseLength / 2.0, 2) + Math.pow(height, 2));
    }

    // Implement abstract methods from Shape3D
    @Override
    protected double calculateSurfaceArea() {
        double baseArea = Math.pow(baseLength, 2);
        double lateralArea = 2 * baseLength * getSlantHeight();
        return baseArea + lateralArea;
    }

    @Override
    protected double calculateVolume() {
        return (1.0 / 3.0) * Math.pow(baseLength, 2) * height;
    }

    // Override toString for pyramid-specific formatting
    @Override
    public String toString() {
        return "SquarePyramid [Name=" + getName() +
                ", Color=" + getColor() +
                ", Base Length=" + baseLength +
                ", Height=" + height +
                ", Slant Height=" + getSlantHeight() +
                ", Surface Area=" + getSurfaceArea() +
                ", Volume=" + getVolume() + "]";
    }
}


