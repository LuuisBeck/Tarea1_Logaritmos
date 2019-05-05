package com.mycompany.app.datastructures;

import java.util.List;
import java.util.ArrayList;

public class Node {
  int min_m;
  int max_m;
  Rectangle mbr;
  List<Node> sons;

/*todo nodo nace como una hoja, es decir, con la lista iner_recs vacía.*/
  public Node(int minm, int maxm, Rectangle mbr){
    assert minm < maxm;
    this.min_m = minm;
    this.max_m = maxm;
    this.mbr = mbr;
    sons = new ArrayList();
  }

  public Rectangle getMBR(){
    return this.mbr;
  }


  public void addSon(Node node){
    this.sons.add(node);
  }

  public List<Node> getSons(){
    return sons;
  }


  public boolean isLeaf(){
    if (sons.size() == 0) {
      return true;
    }
    else return false;
  }

  public boolean overflowNeeded(){
    if (this.isLeaf()){
      return false;
    }
    if (this.sons.size()>this.max_m){
      return true;
    }
    boolean needed = false;
    for (Node son : this.sons){
      needed = needed || son.overflowNeeded();
    }
    return needed;
  }

  /*recorre los hijos del nodo encontrando todos los rectángulos en los nodos hojas que intersectan al rectangulo argumento*/
  public List<Rectangle> buscar(Rectangle rectangle){
    List<Rectangle> intersectantes = new ArrayList<Rectangle>();
    if (rectangle.intersect(this.mbr)){
      intersectantes.add(this.mbr);
    }
    for (Node son : this.sons){
      if (rectangle.intersect(son.getMBR()) || rectangle.inside(son.getMBR())){
        intersectantes.addAll(son.buscar(rectangle));
      }
    }
    return intersectantes;
  }

  public void insertar(Node newNode){
    /*TODO*/
    ;
  }

  public List<Rectangle> allRectangles(){
    /*TODO*/
    return null;
  }

}
