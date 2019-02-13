public class KnightBoard {
  private int[][] board;
  private int rows;
  private int cols;

  /**
  *@throws IllegalArgumentException when either parameter is negative.
  *Initialize the board to the correct size and make them all 0's
  */
  public KnightBoard(int startingRows,int startingCols) {
    if (startingRows <= 0 || startingCols <= 0) {
      throw new IllegalArgumentException();
    }
    board = new int[startingRows][startingCols];
    rows = startingRows;
    cols = startingCols;
    //creates board with the correct size
  }


  public String toString() {
    String ans = "";
    for (int r = 0; r < board.length; r++) {
      for (int c=0; c<board[r].length; c++) {
        if (board[r][c] == 0) {
          ans+=" _";
        }
        else {
          if (r*c>10 && board[r][c] < 10) {
            ans+="  " + board[r][c];
          }
          else {
            ans+=board[r][c];
          }
        }
      }
      ans+="\n";
    }
    return ans;
  }

  /**
  *Modifies the board by labeling the moves from 1 (at startingRow,startingCol)
  *up to the area of the board in proper knight move steps.
  *@throws IllegalStateException when the board contains non-zero values.
  *@throws IllegalArgumentException when either parameter is negative or out of bounds.
  */
  public boolean solve(int startingRow, int startingCol) {
    if (startingRow < 0 || startingRow > rows || startingCol < 0 || startingCol > 0) {
      throw new IllegalArgumentException();
    }
    board[startingRow][startingCol] = 1;
    // return solveH()
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
