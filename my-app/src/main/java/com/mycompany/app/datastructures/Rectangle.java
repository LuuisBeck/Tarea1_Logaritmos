package com.mycompany.app.datastructures;

public class Rectangle {
  private Point ld, ru;

  public Rectangle(){
    this.ld = new Point();
    this.ru = new Point(1,1);
  }

  public Rectangle(int x1, int y1, int x2, int y2)
  {
    assert x1<x2 && y1<y2;
    this.ld = new Point(x1, y1);
    this.ru = new Point(x2,y2);
  }

  public Rectangle(Point ld, Point ru){
    assert ld.getX()<ru.getX() && ld.getY()<ru.getY();
    this.ld = ld;
    this.ru = ru;
  }

  public int getArea() {
    return (Math.abs(ru.getX() - ld.getX())*Math.abs(ru.getY() - ld.getY()));
  }

  public Point getP1() {
     return this.ld;
  }

  public Point getP2() {
    return this.ru;
  }

  public Point getLD() {
     return this.ld;
  }

  public Point getRU() {
    return this.ru;
  }

  public boolean intersect(Rectangle rectangle){
    int a,b,c,d,x,y,s,t;
    a = this.getP1().getX();
    b = this.getP1().getY();
    c = this.getP2().getX();
    d = this.getP2().getY();
    x = rectangle.getP1().getX();
    y = rectangle.getP1().getY();
    s = rectangle.getP2().getX();
    t = rectangle.getP2().getY();
    return !(t<a  || s<b || c<x || d<y);
  }
/*this adentro de rectangle*/
  public boolean inside(Rectangle rectangle){
    int a,b,c,d,x,y,s,t;
    a = this.getP1().getX();
    b = this.getP1().getY();
    c = this.getP2().getX();
    d = this.getP2().getY();
    x = rectangle.getP1().getX();
    y = rectangle.getP1().getY();
    s = rectangle.getP2().getX();
    t = rectangle.getP2().getY();
    return (x<=a && y<=b && c<=s && d<=t);
  }

}
