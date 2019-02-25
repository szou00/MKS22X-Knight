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
          if (rows*cols>10 && board[r][c] < 10) {
            ans+="  " + board[r][c];
          }
          else {
            ans+=" " + board[r][c];
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

  public boolean solveH(int row ,int col, int level) {
    if (level > rows * cols) {
      return true;
    }
    else {
      if (addKnight(row,col,level)) {
        if (solveH(row+2,col+1,level+1)) {
          return true;
        }
        if (solveH(row+2,col-1,level+1)) {
          return true;
        }
        if (solveH(row-2,col+1,level+1)) {
          return true;
        }
        if (solveH(row-2,col-1,level+1)) {
          return true;
        }
        if (solveH(row+1,col+2,level+1)) {
          return true;
        }
        if (solveH(row-1,col+2,level+1)) {
          return true;
        }
        if (solveH(row+1,col-2,level+1)) {
          return true;
        }
        if (solveH(row-1,col-2,level+1)) {
          return true;
        }
      System.out.println(removeKnight(row,col,level));
    }
  }
    return false;
  }
  // level is the # of the knight

  public boolean addKnight(int row, int col, int level) {
    if (row >= rows || row < 0 || col >= cols || col < 0) {
      return false; //can't add the knight if the position is not valid
    }
    if (board[row][col] == 0) {
      board[row][col] = level; //if the position is available, the knight will be added
      return true;
    }
    else {
      return false; //if not, it will not be added
    }
  }

  public boolean removeKnight(int row, int col, int level) {
    if (rows >= rows || row < 0 || col >= cols || col < 0) {
      System.out.println("wasn't zero");
      return false; //can't remove if the position isn't valid
    }
    if (board[row][col] != 0) {
      board[row][col] = 0;
      return true;
    }
    else {
      System.out.println("wasn't zero");
      return false;
    }
  }

}
