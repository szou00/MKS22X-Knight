public class driver {

  public static void main(String[] args) {
    KnightBoard test = new KnightBoard(10,10);
    System.out.println(test);
    test.solveH(0,0,1);
    System.out.println(test);
  }
}
