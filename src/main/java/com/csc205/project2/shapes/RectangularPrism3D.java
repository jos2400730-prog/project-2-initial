package com.csc205.project2.shapes;
/**
 * AI GENERATION DOCUMENTATION
 * ===========================
 * AI Tool Used: [ChatGpt-5]
 * Generation Date: 10/2/2025
 *
 * Original Prompt:
 * all right, second to last shape: RectangularPrism3D. its properties will be length, width, and height.
 * In spite of being repetitive, I must emphasize that the requirements are
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
public class RectangularPrism3D extends Shape3D {
    private double length;
    private double width;
    private double height;

    // Constructor
    public RectangularPrism3D(String name, String color, double length, double width, double height) {
        super(name, color);
        setLength(length); // use setters for validation
        setWidth(width);
        setHeight(height);
    }

    // Getters and setters with validation
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be greater than zero.");
        }
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width must be greater than zero.");
        }
        this.width = width;
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
        return 2 * (length * width + length * height + width * height);
    }

    @Override
    protected double calculateVolume() {
        return length * width * height;
    }

    // Optional shape-specific method
    public double getSpaceDiagonal() {
        return Math.sqrt(Math.pow(length, 2) + Math.pow(width, 2) + Math.pow(height, 2));
    }

    // Override toString for rectangular prism-specific formatting
    @Override
    public String toString() {
        return "RectangularPrism [Name=" + getName() +
                ", Color=" + getColor() +
                ", Length=" + length +
                ", Width=" + width +
                ", Height=" + height +
                ", Space Diagonal=" + getSpaceDiagonal() +
                ", Surface Area=" + getSurfaceArea() +
                ", Volume=" + getVolume() + "]";
    }
}

