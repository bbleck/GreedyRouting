import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Routing {

  private static List<Site> sites = new LinkedList<>();
  private static int xMax = 10;
  private static int yMax = 10;
  private static int numberOfSites = 5;
  private static int hops = 3;
  private static Site startingLoc;
  private static Random rand = new Random();

  public static void main(String[] args) {
    startingLoc = new Site(0,0);
    setupSites();
    Site[] result = getHops(hops);
    System.out.println("\n\n\n");
    printResult(result);
    //array to list:  List<Site> sitesAsList = Arrays.asList(result);
  }

  private static void printResult(Site[] result) {
    for (int i = 0; i < result.length; i++) {
      System.out.println("x: " + result[i].getX() + "  y: " + result[i].getY());
    }
  }

  private static Site[] getHops(int hops) {
    List<Site> resultBuilder = new LinkedList<>();
    for (int i = 0; i < hops; i++) {
      sortSites();
      resultBuilder.add(sites.get(0));
      startingLoc = sites.get(0);
      sites.remove(0);
      updateSitesDistances();
    }
    return resultBuilder.toArray(new Site[0]);
  }

  private static void updateSitesDistances() {
    for (int i = 0; i < sites.size(); i++) {
      sites.get(i).setDistanceSquare2Origin(startingLoc);
    }
  }

  private static void sortSites() {
    Collections.sort(sites);
  }

  private static void setupSites() {
    for (int i = 0; i < numberOfSites; i++) {
      sites.add(new Site(rand.nextInt(xMax)+1, rand.nextInt(yMax)+1, startingLoc));
    }
    printResult(sites.toArray(new Site[0]));
  }

}
