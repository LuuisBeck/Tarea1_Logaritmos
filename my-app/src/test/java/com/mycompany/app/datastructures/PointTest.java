package com.mycompany.app.datastructures;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import com.mycompany.app.datastructures.Point;
import org.junit.Test;

/**
 * Unit test for Point Class.
 */
public class PointTest
{
    /**
     * Rigorous Test
     */
    @Test
    public void createTheOriginPoint()
    {
        Point p = new Point();
        assertEquals(0,p.getX());
        assertEquals(0,p.getY());
    }

    /**
     * Rigorous Test
     */
    @Test
    public void makePointPoint()
    {
        Point p = new Point(5,6);
        assertEquals(5,p.getX());
        assertEquals(6,p.getY());
    }

    /**
     * Rigorous Test
     */
    @Test
    public void makePointFromPoint()
    {
        Point p = new Point();
        Point second = p.makeUperRightPoint(1,2);
        assertEquals(1,second.getX());
        assertEquals(2,second.getY());
    }
}
