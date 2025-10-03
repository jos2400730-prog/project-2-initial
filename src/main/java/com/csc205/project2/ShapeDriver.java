package com.csc205.project2;

/**
 * AI GENERATION DOCUMENTATION
 * ===========================
 * AI Tool Used: [ChatGpt-5]
 * Generation Date: 10/2/2025
 *
 * Original Prompt:
 * "[all right, now we move on to the driver class! this one is to be our sophisticaded ShapeDriver.java that holds our main and will demonstrate our codes efficacy.
 * it MUST Polymorphism: Array/List of Shape3D references holding different shapes Comparative Analysis:
 * Which shape has the largest volume for given constraints?
 * Interactive Features: Allow user to create shapes with custom parameters Performance
 * Timing: Measure calculation speeds (optional)
 * Formatted Output: Professional presentation of results
 * Before you build this code, I am going to give you an example output
 *
 * === 3D Shape Analysis System ===
 *
 * Created Shapes: 1. Sphere {name='Red Ball', radius=5.0}
 * - Surface Area: 314.16 square units
 * - Volume: 523.60 cubic units
 *
 * 2. Cube {name='Blue Box', side=4.0}
 * - Surface Area: 96.00 square units
 * - Volume: 64.00 cubic units
 *
 * [... other shapes ...]
 *
 * Analysis Results:
 * - Largest Volume: Red Ball (523.60)
 * - Largest Surface Area: Red Ball (314.16)
 * - Most Efficient (Volume/Surface): Blue Box (0.67)]"
 *]
 *
 *
 * Follow-up Prompts (if any):
 * 1. "[Refinement prompt 1]"
 * 2. "[Refinement prompt 2]"
 *
 * Manual Modifications:
 * - [List any changes you made to the AI output]
 * - [Explain why changes were necessary]
 */

import java.util.*;
import java.text.DecimalFormat;

import com.csc205.project2.shapes.*;


public class ShapeDriver {

    private static final Scanner scanner = new Scanner(System.in);
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        System.out.println("=== 3D Shape Analysis System ===\n");

        List<Shape3D> shapes = new ArrayList<>();

        // Predefined shapes
        shapes.add(new Sphere3D("Red Ball", "Red", 5.0));
        shapes.add(new Cube3D("Blue Box", "Blue", 4.0));
        shapes.add(new Cylinder3D("Green Tube", "Green", 3.0, 7.0));
        shapes.add(new RectangularPrism3D("Yellow Brick", "Yellow", 2.0, 3.0, 6.0));
        shapes.add(new SquarePyramid3D("Purple Pyramid", "Purple", 4.0, 6.0));

        // Allow user to add custom shape
        addCustomShape(shapes);

        // Show created shapes
        System.out.println("Created Shapes:");
        int i = 1;
        for (Shape3D shape : shapes) {
            System.out.println(i++ + ". " + shape.toString());
            System.out.println("   - Surface Area: " + df.format(shape.getSurfaceArea()) + " square units");
            System.out.println("   - Volume: " + df.format(shape.getVolume()) + " cubic units\n");
        }

        // Comparative Analysis
        analyzeShapes(shapes);
    }

    private static void addCustomShape(List<Shape3D> shapes) {
        System.out.print("Would you like to add a custom shape? (yes/no): ");
        String response = scanner.nextLine().trim().toLowerCase();

        if (!response.equals("yes")) return;

        System.out.println("Choose a shape type: sphere, cube, cylinder, prism, pyramid");
        String type = scanner.nextLine().trim().toLowerCase();

        System.out.print("Enter shape name: ");
        String name = scanner.nextLine();

        System.out.print("Enter shape color: ");
        String color = scanner.nextLine();

        try {
            switch (type) {
                case "sphere":
                    System.out.print("Enter radius: ");
                    double r = Double.parseDouble(scanner.nextLine());
                    shapes.add(new Sphere3D(name, color, r));
                    break;
                case "cube":
                    System.out.print("Enter side length: ");
                    double s = Double.parseDouble(scanner.nextLine());
                    shapes.add(new Cube3D(name, color, s));
                    break;
                case "cylinder":
                    System.out.print("Enter radius: ");
                    double cr = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter height: ");
                    double ch = Double.parseDouble(scanner.nextLine());
                    shapes.add(new Cylinder3D(name, color, cr, ch));
                    break;
                case "prism":
                    System.out.print("Enter length: ");
                    double l = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter width: ");
                    double w = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter height: ");
                    double h = Double.parseDouble(scanner.nextLine());
                    shapes.add(new RectangularPrism3D(name, color, l, w, h));
                    break;
                case "pyramid":
                    System.out.print("Enter base length: ");
                    double b = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter height: ");
                    double ph = Double.parseDouble(scanner.nextLine());
                    shapes.add(new SquarePyramid3D(name, color, b, ph));
                    break;
                default:
                    System.out.println("Unknown shape type. Skipping custom shape.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Skipping custom shape.");
        }
    }

    private static void analyzeShapes(List<Shape3D> shapes) {
        Shape3D largestVolume = null;
        Shape3D largestSurface = null;
        Shape3D mostEfficient = null;
        double bestEfficiency = -1;

        for (Shape3D shape : shapes) {
            if (largestVolume == null || shape.getVolume() > largestVolume.getVolume()) {
                largestVolume = shape;
            }
            if (largestSurface == null || shape.getSurfaceArea() > largestSurface.getSurfaceArea()) {
                largestSurface = shape;
            }
            double efficiency = shape.getVolume() / shape.getSurfaceArea();
            if (efficiency > bestEfficiency) {
                bestEfficiency = efficiency;
                mostEfficient = shape;
            }
        }

        System.out.println("Analysis Results:");
        if (largestVolume != null)
            System.out.println("- Largest Volume: " + largestVolume.getName() +
                    " (" + df.format(largestVolume.getVolume()) + ")");
        if (largestSurface != null)
            System.out.println("- Largest Surface Area: " + largestSurface.getName() +
                    " (" + df.format(largestSurface.getSurfaceArea()) + ")");
        if (mostEfficient != null)
            System.out.println("- Most Efficient (Volume/Surface): " + mostEfficient.getName() +
                    " (" + df.format(bestEfficiency) + ")");
    }
}


