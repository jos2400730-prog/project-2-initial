package com.csc205.project2.shapes.test;


import com.csc205.project2.shapes.Shape3D;
import com.csc205.project2.shapes.Sphere3D;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SphereTest {

    @Test
    void testConstructorAndGetters() {
        Sphere3D sphere = new Sphere3D("TestSphere", "Red", 5.0);
        assertEquals("TestSphere", sphere.getName());
        assertEquals("Red", sphere.getColor());
        assertEquals(5.0, sphere.getRadius());
    }

    @Test
    void testSetters() {
        Sphere3D sphere = new Sphere3D("TestSphere", "Red", 5.0);
        sphere.setName("UpdatedSphere");
        sphere.setColor("Blue");
        sphere.setRadius(10.0);

        assertEquals("UpdatedSphere", sphere.getName());
        assertEquals("Blue", sphere.getColor());
        assertEquals(10.0, sphere.getRadius());
    }

    @Test
    void testSurfaceAreaAndVolumeAccuracy() {
        Sphere3D sphere = new Sphere3D("TestSphere", "Red", 1.0);
        // Surface area of radius 1 = 4π
        assertEquals(4 * Math.PI, sphere.getSurfaceArea(), 1e-6);
        // Volume of radius 1 = 4/3 π
        assertEquals((4.0 / 3.0) * Math.PI, sphere.getVolume(), 1e-6);
    }

    @Test
    void testBoundaryValues() {
        Sphere3D smallSphere = new Sphere3D("TinySphere", "Green", 1e-9);
        assertTrue(smallSphere.getVolume() > 0);
        Sphere3D largeSphere = new Sphere3D("HugeSphere", "Black", 1e6);
        assertTrue(largeSphere.getSurfaceArea() > 0);
    }

    @Test
    void testInvalidValues() {
        assertThrows(IllegalArgumentException.class, () -> new Sphere3D("InvalidSphere", "Gray", -5.0));
        Sphere3D sphere = new Sphere3D("TestSphere", "Red", 5.0);
        assertThrows(IllegalArgumentException.class, () -> sphere.setRadius(0));
        assertThrows(IllegalArgumentException.class, () -> sphere.setRadius(-1));
    }

    @Test
    void testPolymorphism() {
        Shape3D shape = new Sphere3D("PolySphere", "Yellow", 2.0);
        assertEquals(4 * Math.PI * 4, shape.getSurfaceArea(), 1e-6); // r=2, SA=4πr²=16π
        assertEquals((4.0 / 3.0) * Math.PI * 8, shape.getVolume(), 1e-6); // r=2, V=33.51...
    }
}




