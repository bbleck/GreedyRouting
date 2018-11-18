public class Site implements Comparable<Site>{
 private int x;
 private int y;
 private int distanceSquare2Origin;

  public Site(int x, int y, Site origin) {
    this.x = x;
    this.y = y;
    setDistanceSquare2Origin(origin);
  }

  public Site(int x, int y){
    this.x = x;
    this.y = y;
    this.distanceSquare2Origin = 0;
  }

  public int getDistanceSquare2Origin() {
    return distanceSquare2Origin;
  }

  public void setDistanceSquare2Origin(Site origin){
    distanceSquare2Origin =  ((getX()-origin.getX())*(getX()-origin.getX())+((getY()-origin.getY())*(getY()-origin.getY())));
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  @Override
  public int compareTo(Site o) {
    return distanceSquare2Origin-o.distanceSquare2Origin;
  }
}
