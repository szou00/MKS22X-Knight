public class KnightBoard {
  private int[][] board;
  private int rows;
  private int cols;
  private int[][] moves = {{-2, -1}, {-2,1}, {-1,-2}, {1,-2}, {2,-1}, {2,1}, {-1,2}, {1,2}};;

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
    if (!isCleared()) {
      throw new IllegalStateException();
    }
    if (startingRow < 0 || startingRow >= rows || startingCol < 0 || startingCol >= cols) {
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
    if (!isCleared()) {
      throw new IllegalStateException();
    }
    if (startingRow < 0 || startingRow >= rows || startingCol < 0 || startingCol >= cols) {
      throw new IllegalArgumentException();
    }
    return findAll(startingRow, startingCol,1);
  }

  public int findAll(int row, int col, int level) {
    int ans = 0;
    if (addKnight(row,col,level)) {
      if (level != rows * cols) {
        for (int x=0;x<moves.length;x++) {
          ans += findAll(row+moves[x][0],col+moves[x][1],level+1);
        }
      }
      else {
        removeKnight(row,col,level);
        return 1;
      }
      removeKnight(row,col,level);
    }
    return ans;
  }

  public boolean solveH(int row ,int col, int level) {
    if (level > rows * cols) {
      return true;
    }
    for (int x=0; x<moves.length;x++) {
      if (addKnight(row,col,level)) {
        if (solveH(row+moves[x][0],col+moves[x][1],level+1)) {
          return true;
        }
        removeKnight(row,col,level);
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
    return false; //if not, it will not be added
  }

  public boolean removeKnight(int row, int col, int level) {
    if (row >= rows || row < 0 || col >= cols || col < 0) {
      return false; //can't remove if the position isn't valid
    }
    if (board[row][col] != 0) {
      board[row][col] = 0;
      return true;
    }
    return false;
  }

  public boolean isCleared() {
    for (int r = 0; r<rows;r++) {
      for (int c = 0; c<cols;c++) {
        if (board[r][c] != 0) {
          return false;
        }
      }
    }
    return true;
  }

}
