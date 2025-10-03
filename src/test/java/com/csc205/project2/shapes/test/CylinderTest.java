package com.csc205.project2.shapes.test;


import com.csc205.project2.shapes.Cylinder3D;
import com.csc205.project2.shapes.Shape3D;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CylinderTest {

    @Test
    void testConstructorAndGetters() {
        Cylinder3D cylinder = new Cylinder3D("TestCylinder", "Red", 2.0, 5.0);
        assertEquals("TestCylinder", cylinder.getName());
        assertEquals("Red", cylinder.getColor());
        assertEquals(2.0, cylinder.getRadius());
        assertEquals(5.0, cylinder.getHeight());
    }

    @Test
    void testSetters() {
        Cylinder3D cylinder = new Cylinder3D("TestCylinder", "Red", 2.0, 5.0);
        cylinder.setName("UpdatedCylinder");
        cylinder.setColor("Blue");
        cylinder.setRadius(3.0);
        cylinder.setHeight(6.0);

        assertEquals("UpdatedCylinder", cylinder.getName());
        assertEquals("Blue", cylinder.getColor());
        assertEquals(3.0, cylinder.getRadius());
        assertEquals(6.0, cylinder.getHeight());
    }

    @Test
    void testSurfaceAreaAndVolumeAccuracy() {
        Cylinder3D cylinder = new Cylinder3D("UnitCylinder", "Green", 1.0, 1.0);
        // SA = 2πr² + 2πrh = 2π(1²) + 2π(1*1) = 4π
        assertEquals(4 * Math.PI, cylinder.getSurfaceArea(), 1e-6);
        // V = πr²h = π(1²)(1) = π
        assertEquals(Math.PI, cylinder.getVolume(), 1e-6);

        Cylinder3D cylinder2 = new Cylinder3D("TallCylinder", "Yellow", 2.0, 3.0);
        // SA = 2π(2²) + 2π(2*3) = 8π + 12π = 20π
        assertEquals(20 * Math.PI, cylinder2.getSurfaceArea(), 1e-6);
        // V = π(2²)(3) = 12π
        assertEquals(12 * Math.PI, cylinder2.getVolume(), 1e-6);
    }

    @Test
    void testBoundaryValues() {
        Cylinder3D smallCylinder = new Cylinder3D("TinyCylinder", "Gray", 1e-9, 1e-9);
        assertTrue(smallCylinder.getVolume() > 0);

        Cylinder3D largeCylinder = new Cylinder3D("HugeCylinder", "Black", 1e6, 1e6);
        assertTrue(largeCylinder.getSurfaceArea() > 0);
    }

    @Test
    void testInvalidValues() {
        assertThrows(IllegalArgumentException.class, () -> new Cylinder3D("BadCylinder", "White", -2.0, 5.0));
        assertThrows(IllegalArgumentException.class, () -> new Cylinder3D("BadCylinder2", "White", 2.0, -5.0));

        Cylinder3D cylinder = new Cylinder3D("ValidCylinder", "Red", 2.0, 5.0);
        assertThrows(IllegalArgumentException.class, () -> cylinder.setRadius(0));
        assertThrows(IllegalArgumentException.class, () -> cylinder.setHeight(-10));
    }

    @Test
    void testPolymorphism() {
        Shape3D shape = new Cylinder3D("PolyCylinder", "Purple", 1.0, 2.0);
        // SA = 2π(1²) + 2π(1*2) = 2π + 4π = 6π
        assertEquals(6 * Math.PI, shape.getSurfaceArea(), 1e-6);
        // V = π(1²)(2) = 2π
        assertEquals(2 * Math.PI, shape.getVolume(), 1e-6);
    }
}

