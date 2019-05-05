package com.mycompany.app.datastructures;

import java.util.Random;

public class Point {
  private int x, y;

  public Point(){
    this.x = this.y = 0;
  }
  public Point(int x, int y){
    this.x = x;
    this.y = y;
  }

  public Point makeUperRightPoint(int dx, int dy){
    return new Point(this.x + dx, this.y + dy);
  }

  public int getX(){
    return this.x;
  }

  public int getY(){
    return this.y;
  }

  public void setX(int x){
    this.x = x;
  }

  public void setY(int y){
    this.x = x;
  }

}
