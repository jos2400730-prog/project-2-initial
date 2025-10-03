package com.csc205.project2.shapes.test;


import com.csc205.project2.shapes.RectangularPrism3D;
import com.csc205.project2.shapes.Shape3D;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RectangularPrismTest {

    @Test
    void testConstructorAndGetters() {
        RectangularPrism3D prism = new RectangularPrism3D("TestPrism", "Red", 2.0, 3.0, 4.0);
        assertEquals("TestPrism", prism.getName());
        assertEquals("Red", prism.getColor());
        assertEquals(2.0, prism.getLength());
        assertEquals(3.0, prism.getWidth());
        assertEquals(4.0, prism.getHeight());
    }

    @Test
    void testSetters() {
        RectangularPrism3D prism = new RectangularPrism3D("TestPrism", "Red", 2.0, 3.0, 4.0);
        prism.setName("UpdatedPrism");
        prism.setColor("Blue");
        prism.setLength(5.0);
        prism.setWidth(6.0);
        prism.setHeight(7.0);

        assertEquals("UpdatedPrism", prism.getName());
        assertEquals("Blue", prism.getColor());
        assertEquals(5.0, prism.getLength());
        assertEquals(6.0, prism.getWidth());
        assertEquals(7.0, prism.getHeight());
    }

    @Test
    void testSurfaceAreaAndVolumeAccuracy() {
        RectangularPrism3D prism = new RectangularPrism3D("UnitPrism", "Green", 1.0, 1.0, 1.0);
        // SA = 2(lw + lh + wh) = 2(1*1 + 1*1 + 1*1) = 6
        assertEquals(6.0, prism.getSurfaceArea(), 1e-6);
        // V = l * w * h = 1
        assertEquals(1.0, prism.getVolume(), 1e-6);

        RectangularPrism3D prism2 = new RectangularPrism3D("Prism2", "Yellow", 2.0, 3.0, 4.0);
        // SA = 2(2*3 + 2*4 + 3*4) = 2(6 + 8 + 12) = 52
        assertEquals(52.0, prism2.getSurfaceArea(), 1e-6);
        // V = 2*3*4 = 24
        assertEquals(24.0, prism2.getVolume(), 1e-6);
    }

    @Test
    void testBoundaryValues() {
        RectangularPrism3D smallPrism = new RectangularPrism3D("TinyPrism", "Gray", 1e-9, 1e-9, 1e-9);
        assertTrue(smallPrism.getVolume() > 0);

        RectangularPrism3D largePrism = new RectangularPrism3D("HugePrism", "Black", 1e6, 1e6, 1e6);
        assertTrue(largePrism.getSurfaceArea() > 0);
    }

    @Test
    void testInvalidValues() {
        assertThrows(IllegalArgumentException.class, () -> new RectangularPrism3D("BadPrism", "White", -1.0, 2.0, 3.0));
        assertThrows(IllegalArgumentException.class, () -> new RectangularPrism3D("BadPrism2", "White", 1.0, -2.0, 3.0));
        assertThrows(IllegalArgumentException.class, () -> new RectangularPrism3D("BadPrism3", "White", 1.0, 2.0, -3.0));

        RectangularPrism3D prism = new RectangularPrism3D("ValidPrism", "Red", 2.0, 3.0, 4.0);
        assertThrows(IllegalArgumentException.class, () -> prism.setLength(0));
        assertThrows(IllegalArgumentException.class, () -> prism.setWidth(-5));
        assertThrows(IllegalArgumentException.class, () -> prism.setHeight(-10));
    }

    @Test
    void testPolymorphism() {
        Shape3D shape = new RectangularPrism3D("PolyPrism", "Purple", 2.0, 3.0, 4.0);
        assertEquals(52.0, shape.getSurfaceArea(), 1e-6); // from earlier calculation
        assertEquals(24.0, shape.getVolume(), 1e-6);      // 2*3*4
    }
}


