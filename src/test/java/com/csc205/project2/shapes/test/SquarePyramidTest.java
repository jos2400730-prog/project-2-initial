package com.csc205.project2.shapes.test;


import com.csc205.project2.shapes.Shape3D;
import com.csc205.project2.shapes.SquarePyramid3D;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SquarePyramid3DTest {

    @Test
    void testConstructorAndGetters() {
        SquarePyramid3D pyramid = new SquarePyramid3D("TestPyramid", "Red", 4.0, 6.0);
        assertEquals("TestPyramid", pyramid.getName());
        assertEquals("Red", pyramid.getColor());
        assertEquals(4.0, pyramid.getBaseLength());
        assertEquals(6.0, pyramid.getHeight());
    }

    @Test
    void testSetters() {
        SquarePyramid3D pyramid = new SquarePyramid3D("TestPyramid", "Red", 4.0, 6.0);
        pyramid.setName("UpdatedPyramid");
        pyramid.setColor("Blue");
        pyramid.setBaseLength(5.0);
        pyramid.setHeight(7.0);

        assertEquals("UpdatedPyramid", pyramid.getName());
        assertEquals("Blue", pyramid.getColor());
        assertEquals(5.0, pyramid.getBaseLength());
        assertEquals(7.0, pyramid.getHeight());
    }

    @Test
    void testSurfaceAreaAndVolumeAccuracy() {
        // Base = 2, Height = 2
        SquarePyramid3D pyramid = new SquarePyramid3D("UnitPyramid", "Green", 2.0, 2.0);
        // Volume = (1/3) * (2^2) * 2 = (1/3) * 8 = 8/3
        assertEquals(8.0 / 3.0, pyramid.getVolume(), 1e-6);

        // SlantHeight = sqrt((2/2)^2 + 2^2) = sqrt(1 + 4) = sqrt(5)
        // SA = base^2 + 2 * base * slantHeight = 4 + 2*2*sqrt(5) = 4 + 4√5
        assertEquals(4 + 4 * Math.sqrt(5), pyramid.getSurfaceArea(), 1e-6);

        // Bigger test
        SquarePyramid3D pyramid2 = new SquarePyramid3D("BigPyramid", "Yellow", 3.0, 4.0);
        // Volume = (1/3) * (9) * 4 = 12
        assertEquals(12.0, pyramid2.getVolume(), 1e-6);
    }

    @Test
    void testBoundaryValues() {
        SquarePyramid3D tinyPyramid = new SquarePyramid3D("TinyPyramid", "Gray", 1e-9, 1e-9);
        assertTrue(tinyPyramid.getVolume() > 0);

        SquarePyramid3D hugePyramid = new SquarePyramid3D("HugePyramid", "Black", 1e6, 1e6);
        assertTrue(hugePyramid.getSurfaceArea() > 0);
    }

    @Test
    void testInvalidValues() {
        assertThrows(IllegalArgumentException.class, () -> new SquarePyramid3D("BadPyramid1", "White", -2.0, 5.0));
        assertThrows(IllegalArgumentException.class, () -> new SquarePyramid3D("BadPyramid2", "White", 2.0, -5.0));

        SquarePyramid3D pyramid = new SquarePyramid3D("ValidPyramid", "Red", 2.0, 3.0);
        assertThrows(IllegalArgumentException.class, () -> pyramid.setBaseLength(0));
        assertThrows(IllegalArgumentException.class, () -> pyramid.setHeight(-10));
    }

    @Test
    void testPolymorphism() {
        Shape3D shape = new SquarePyramid3D("PolyPyramid", "Purple", 3.0, 4.0);
        // Volume = (1/3) * 9 * 4 = 12
        assertEquals(12.0, shape.getVolume(), 1e-6);
    }
}


