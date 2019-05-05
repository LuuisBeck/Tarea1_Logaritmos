package com.mycompany.app.datastructures;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import com.mycompany.app.datastructures.Point;
import com.mycompany.app.datastructures.Rectangle;
import org.junit.Test;

/**
 * Unit test for Point Class.
 */
public class RectangleTest
{
    /**
     * Rigorous Test
     */
    @Test
    public void createUnitaryRectangle()
    {
        Rectangle r = new Rectangle();
        Point p0 = new Point(0,0);
        Point p1 = new Point(1,1);
        assertEquals(0,r.getLD().getX());
        assertEquals(0,r.getLD().getY());
        assertEquals(1,r.getRU().getX());
        assertEquals(1,r.getRU().getY());
    }

    /**
     * Rigorous Test
     */
    @Test
    public void invalidRectangle()
    {
      try
      {
        Rectangle r = new Rectangle(1,1,1,1);
        fail();
      } catch (AssertionError e) {
        assertTrue(true);
      }
      try
      {
        Rectangle r = new Rectangle(new Point(1,2), new Point(2,0));
        fail();
      } catch (AssertionError e) {
        assertTrue(true);
      }
    }

    /**
     * Rigorous Test
     */
    @Test
    public void makeNormalRectangle()
    {
        Point p1 = new Point(5,6);
        Point p2 = new Point(10, 9);
        Rectangle r = new Rectangle(p1,p2);
        Rectangle r2 = new Rectangle(1,2,3,4);
        assertEquals(p1.getX(),r.getLD().getX());
        assertEquals(p1.getY(),r.getLD().getY());
        assertEquals(p2.getX(),r.getRU().getX());
        assertEquals(p2.getY(),r.getRU().getY());
        assertEquals(1,r2.getLD().getX());
        assertEquals(2,r2.getLD().getY());
        assertEquals(3,r2.getRU().getX());
        assertEquals(4,r2.getRU().getY());
    }

    /**
     * Rigorous Test
     */
    @Test
    public void areaCalcualtion()
    {
        Rectangle r = new Rectangle(1,1,5,5);
        assertEquals(16, r.getArea());
    }

    @Test
    public void intersectation()
    {
        Rectangle r = new Rectangle(0,0,10,10);
        /* no intersectan con r por el lado l=left, r=right, u=up, d=down */
        Rectangle lr = new Rectangle(-10,0,-1,10);
        Rectangle rr = new Rectangle(11,0,15,10);
        Rectangle ur = new Rectangle(0,11,10,15);
        Rectangle dr = new Rectangle(-10,0,-1,10);
        /* intersectan con r por lados opuestos, extendiendose hacia l=left, r=right, u=up, d=down */
        Rectangle ilr = new Rectangle(-5,-3,2,14);
        Rectangle irr = new Rectangle(5,-20,15,20);
        Rectangle iur = new Rectangle(-5,9,100,12);
        Rectangle idr = new Rectangle(-10,-1,3,11);

        /* intersectan con r por lados opuestos, no extendiendose en el sentido lr=left-right, ud=up-down */
        Rectangle ilrr = new Rectangle(5,-3,6,14);
        Rectangle iudr = new Rectangle(-5,3,15,7);

        /* intersectan con r por dos lados l=left, r=right, u=up, d=down */
        Rectangle iulr = new Rectangle(-10,2,2,13);
        Rectangle iurr = new Rectangle(2,5,13,15);
        Rectangle idrr = new Rectangle(-7,5,3,14);
        Rectangle idlr = new Rectangle(-5,-2,1,7);
        /* intersectan por inside con r por el lado l=left, r=right, u=up, d=down */
        Rectangle iilr = new Rectangle(-2,5,5,6);
        Rectangle iirr = new Rectangle(2,2,15,7);
        Rectangle iiur = new Rectangle(1,2,3,32);
        Rectangle iidr = new Rectangle(4,-7,6,6);
        /* solo intersecta con r por el borde r=right */
        Rectangle brr = new Rectangle(10,0,11,10);

        assertTrue(r.intersect(r));

        assertFalse(r.intersect(lr));
        assertFalse(r.intersect(rr));
        assertFalse(r.intersect(ur));
        assertFalse(r.intersect(dr));

        assertTrue(r.intersect(ilr));
        assertTrue(r.intersect(irr));
        assertTrue(r.intersect(iur));
        assertTrue(r.intersect(idr));

        assertTrue(r.intersect(ilrr));
        assertTrue(r.intersect(iudr));

        assertTrue(r.intersect(iulr));
        assertTrue(r.intersect(iurr));
        assertTrue(r.intersect(idlr));
        assertTrue(r.intersect(idrr));

        assertTrue(r.intersect(iilr));
        assertTrue(r.intersect(iirr));
        assertTrue(r.intersect(iiur));
        assertTrue(r.intersect(iidr));

        assertTrue(r.intersect(brr));

    }

    /**
     * Rigorous Test
     */
    @Test
    public void inside()
    {
        Rectangle r = new Rectangle(0,0,10,10);
        /* este incluye a r */
        Rectangle rext = new Rectangle(-10,-10,11,11);
        /* r tiene a este inside */
        Rectangle rins = new Rectangle(1,1,2,2);

        /* no intersectan con r por el lado l=left, r=right, u=up, d=down */
        Rectangle lr = new Rectangle(-10,0,-1,10);
        Rectangle rr = new Rectangle(11,0,15,10);
        Rectangle ur = new Rectangle(0,11,10,15);
        Rectangle dr = new Rectangle(-10,0,-1,10);
        /* intersectan con r por lados opuestos, extendiendose hacia l=left, r=right, u=up, d=down */
        Rectangle ilr = new Rectangle(-5,-3,2,14);
        Rectangle irr = new Rectangle(5,-20,15,20);
        Rectangle iur = new Rectangle(-5,9,100,12);
        Rectangle idr = new Rectangle(-10,-1,3,11);

        /* intersectan con r por lados opuestos, no extendiendose en el sentido lr=left-right, ud=up-down */
        Rectangle ilrr = new Rectangle(5,-3,6,14);
        Rectangle iudr = new Rectangle(-5,3,15,7);

        /* intersectan con r por dos lados l=left, r=right, u=up, d=down */
        Rectangle iulr = new Rectangle(-10,2,2,13);
        Rectangle iurr = new Rectangle(2,5,13,15);
        Rectangle idrr = new Rectangle(-7,5,3,14);
        Rectangle idlr = new Rectangle(-5,-2,1,7);
        /* intersectan por inside con r por el lado l=left, r=right, u=up, d=down */
        Rectangle iilr = new Rectangle(-2,5,5,6);
        Rectangle iirr = new Rectangle(2,2,15,7);
        Rectangle iiur = new Rectangle(1,2,3,32);
        Rectangle iidr = new Rectangle(4,-7,6,6);
        /* solo intersecta con r por el borde r=right */
        Rectangle brr = new Rectangle(10,0,11,10);

        assertTrue(r.inside(r));
        assertTrue(r.inside(rext));
        assertFalse(r.inside(rins));

        assertFalse(r.inside(lr));
        assertFalse(r.inside(rr));
        assertFalse(r.inside(ur));
        assertFalse(r.inside(dr));

        assertFalse(r.inside(ilr));
        assertFalse(r.inside(irr));
        assertFalse(r.inside(iur));
        assertFalse(r.inside(idr));

        assertFalse(r.inside(ilrr));
        assertFalse(r.inside(iudr));

        assertFalse(r.inside(iulr));
        assertFalse(r.inside(iurr));
        assertFalse(r.inside(idlr));
        assertFalse(r.inside(idrr));

        assertFalse(r.inside(iilr));
        assertFalse(r.inside(iirr));
        assertFalse(r.inside(iiur));
        assertFalse(r.inside(iidr));

        assertFalse(r.inside(brr));

    }
}
