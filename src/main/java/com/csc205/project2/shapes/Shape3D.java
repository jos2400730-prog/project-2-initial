package com.csc205.project2.shapes;
/**
 * AI GENERATION DOCUMENTATION
 * ===========================
 * AI Tool Used: [ChatGpt-5]
 * Generation Date: 10/2/2025
 *
 * Original Prompt:
 * For this, I am in a coding class that has an emphasis on working in tandem with AI in order to code faster and more effectively. we are creating a class called Shape3d.java,
 * and it must implement an interface called ThreeDimenisionalShape.java that contains the code double getSurfaceArea(); double getVolume(); .Shape.3d MUST Implements the ThreeDimensionalShape
 * interface Concrete implementations of getVolume() and getSurfaceArea() that call the abstract methods Common properties: name (String), color (String) (Properties in Java are typically private fields
 * with public getters and setters) Constructor(s) for initialization toString() method that formats output consistently Getter/setter methods as appropriate. THis is the first run, but try your best!
 *
 * Follow-up Prompts (if any):
 * 1. "[Refinement prompt 1]"
 * 2. "[Refinement prompt 2]"
 *
 * Manual Modifications:
 * - [I had to alter the Shape3D.Java segment from the original, as it initially did not
 * include the abstract Key word]
 * - [The abstract keyword is required for calling on an abstract class]
 *
 * Formula Verification:
 * - Volume formula verified against: [The legitimate formula, which it implemented correctly]
 * - Surface area formula verified against: [The legitimate formula, which it implemented correctly]
 */
public abstract class Shape3D implements ThreeDimensionalShape{
    // Common properties
    private String name;
    private String color;
    // Constructor
    public Shape3D(String name, String color) {
        this.name = name;
        this.color = color;
    }

    // Abstract methods that subclasses must implement
    protected abstract double calculateSurfaceArea();
    protected abstract double calculateVolume();
    // Implement interface methods by calling abstract methods
    @Override
    public double getSurfaceArea() {
        return calculateSurfaceArea();
    }

    @Override
    public double getVolume() {
        return calculateVolume();
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // toString() method
    @Override
    public String toString() {
        return "Shape: " + name + ", Color: " + color + ", Surface Area: " + getSurfaceArea() + ", Volume: " + getVolume();
    }
}
