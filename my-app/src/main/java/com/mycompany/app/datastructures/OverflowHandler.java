package com.mycompany.app.datastructures;

class OverflowHandler {
  RTree rtree;

  public void setRTree(RTree rtree){
    this.rtree = rtree;
  }

  public boolean overflowNeeded(){
    return this.rtree.overflowNeeded();
  }
}
