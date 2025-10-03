package com.csc205.project2.shapes.test;


import com.csc205.project2.shapes.Cube3D;
import com.csc205.project2.shapes.Shape3D;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CubeTest {

    @Test
    void testConstructorAndGetters() {
        Cube3D cube = new Cube3D("TestCube", "Red", 3.0);
        assertEquals("TestCube", cube.getName());
        assertEquals("Red", cube.getColor());
        assertEquals(3.0, cube.getSideLength());
    }

    @Test
    void testSetters() {
        Cube3D cube = new Cube3D("TestCube", "Red", 3.0);
        cube.setName("UpdatedCube");
        cube.setColor("Blue");
        cube.setSideLength(4.0);

        assertEquals("UpdatedCube", cube.getName());
        assertEquals("Blue", cube.getColor());
        assertEquals(4.0, cube.getSideLength());
    }

    @Test
    void testSurfaceAreaAndVolumeAccuracy() {
        Cube3D cube = new Cube3D("UnitCube", "Green", 1.0);
        // SA = 6 * 1² = 6
        assertEquals(6.0, cube.getSurfaceArea(), 1e-6);
        // V = 1³ = 1
        assertEquals(1.0, cube.getVolume(), 1e-6);

        Cube3D cube2 = new Cube3D("BigCube", "Yellow", 2.0);
        // SA = 6 * 4 = 24
        assertEquals(24.0, cube2.getSurfaceArea(), 1e-6);
        // V = 8
        assertEquals(8.0, cube2.getVolume(), 1e-6);
    }

    @Test
    void testBoundaryValues() {
        Cube3D tinyCube = new Cube3D("TinyCube", "Gray", 1e-9);
        assertTrue(tinyCube.getVolume() > 0);

        Cube3D hugeCube = new Cube3D("HugeCube", "Black", 1e6);
        assertTrue(hugeCube.getSurfaceArea() > 0);
    }

    @Test
    void testInvalidValues() {
        assertThrows(IllegalArgumentException.class, () -> new Cube3D("BadCube", "White", -1.0));

        Cube3D cube = new Cube3D("ValidCube", "Red", 2.0);
        assertThrows(IllegalArgumentException.class, () -> cube.setSideLength(0));
    }

    @Test
    void testPolymorphism() {
        Shape3D shape = new Cube3D("PolyCube", "Purple", 3.0);
        // SA = 6 * 9 = 54
        assertEquals(54.0, shape.getSurfaceArea(), 1e-6);
        // V = 27
        assertEquals(27.0, shape.getVolume(), 1e-6);
    }
}



