package com.mycompany.datastructures;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import com.mycompany.app.datastructures.Point;
import com.mycompany.app.datastructures.Rectangle;
import com.mycompany.app.datastructures.Node;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class NodeTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void nodeCreation()
    {
        Node n = new Node(1,2, new Rectangle());
        assertTrue(n.getSons().isEmpty());
        assertTrue(n.isLeaf());
        Rectangle r = new Rectangle(1,1,2,2);
        Node n2 = new Node(1,2, r);
        assertEquals(r,n2.getMBR());
        Node n3 = new Node(1,2, new Rectangle());
        Node n4 = new Node(1,2, new Rectangle());
        n.addSon(n2);
        assertFalse(n.isLeaf());
        assertEquals(1,n.getSons().size());
        n.addSon(n3);
        assertEquals(2,n.getSons().size());
        n.addSon(n4);
        assertEquals(3,n.getSons().size());
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void invalidNode()
    {
      try
      {
        Node n = new Node(3,2, new Rectangle());
        fail();
      } catch (AssertionError e) {
        assertTrue(true);
      }
    }


    /**
     * Rigorous Test :-)
     */
    @Test
    public void buscarAllIntersecting()
    {
        Rectangle r0 = new Rectangle();
        Rectangle r = new Rectangle(1,1,2,2);
        Node n = new Node(1,2, r0);
        Node n2 = new Node(1,2, r);
        n.addSon(n2);
        List<Rectangle> resultado = new ArrayList<Rectangle>();
        resultado.add(r0);
        resultado.add(r);
        assertTrue(resultado.equals(n.buscar(r)));
    }
}
