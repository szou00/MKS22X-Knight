public class KnightBoard {
  private int[][] board;

  /**
  *@throws IllegalArgumentException when either parameter is negative.
  *Initialize the board to the correct size and make them all 0's
  */
  public KnightBoard(int startingRows,int startingCols) {
    if (startingRows < 0 || startingCols < 0) {
      throw new IllegalArgumentException();
    }
    board = new int[startingRows][startingCols];
    //creates board with the correct size
  }


  public String toString() {
    String ans = "";
    for (int r = 0; r < board.length; r++) {
      for (int c=0; c<board[r].length; c++) {
        ans+=board[r][c];
      }
    }
    return ans;
  }

  /**
  *@throws IllegalStateException when the board contains non-zero values.
  *@throws IllegalArgumentException when either parameter is negative or out of bounds.
  */
  public boolean solve(int startingRow, int startingCol) {
    return false;
  }

  /**
  *@throws IllegalStateException when the board contains non-zero values.
  *@throws IllegalArgumentException when either parameter is negative
   or out of bounds.
  */
  public int countSolutions(int startingRow, int startingCol) {
    return 0;
  }

  private boolean solveH(int row ,int col, int level) {
    return false;
  }
  // level is the # of the knight

}
