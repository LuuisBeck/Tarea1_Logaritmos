package com.mycompany.app.datastructures;

import java.util.List;
import java.util.ArrayList;

class RTree {
  Node head;
  int min_m;
  int max_m;
  OverflowHandler overflowHandler;

  public RTree(int minm, int maxm, OverflowHandler overflowHandler){
    this.min_m = minm;
    this.max_m = maxm;
    this.overflowHandler = overflowHandler;
    this.overflowHandler.setRTree(this);
  }

  public List<Rectangle> buscar(Rectangle rectangle){
    /*recorre el árbol encontrando todos los rectángulos en los nodos hojas que intersectan al rectangulo argumento*/
    return this.head.buscar(rectangle);
  }

  public void insertar(Rectangle rectangle){
    if (head == null) {
      this.head = new Node(min_m, max_m, rectangle);
    }
    else {
      this.head.insertar(new Node(min_m, max_m, rectangle));
    }

  }

  public List<Rectangle> allRectangles(){
    return this.head.allRectangles();
  }

  public boolean overflowNeeded(){
    if(head == null){
      return false;
    }
    else return head.overflowNeeded();
  }
}
