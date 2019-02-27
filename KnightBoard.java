public class KnightBoard {

  private int[][] board;
  private int rows;
  private int cols;
  private int[][] moves = {{-2, -1}, {-2,1}, {-1,-2}, {1,-2}, {2,-1}, {2,1}, {-1,2}, {1,2}};;
  private int[][] allMoves;

  /**
  *@throws IllegalArgumentException when either parameter is negative.
  *Initialize the board to the correct size and make them all 0's
  */
  public KnightBoard(int startingRows,int startingCols) {
    if (startingRows <= 0 || startingCols <= 0) {
      throw new IllegalArgumentException();
    }
    board = new int[startingRows][startingCols];
    allMoves = new int[startingRows][startingCols];
    rows = startingRows;
    cols = startingCols;
    addAllMoves(); //Initializes the array of moves
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
      decreaseMoves(row,col); //calls the function to modify the number of moves each square has
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

  public void addAllMoves() {
    int start =2;
    for (int r = 0; r<rows;r++) {
      for (int c = 0; c<cols;c++) {
        if (c < cols/2) {
          allMoves[r][c] = start;
          start+=1;
        }
        else {
          if (c<cols-1) {
            allMoves[r][c] = start;
            start-=1;
          }
          else {
            allMoves[r][c] = start;
          }
        }
      }
      if (r < rows/2) {
        start+=1;
      }
      else {
        start-=1;
      }
    }
  }

  //for testing purposes - to see if everything prints out right
  public String printAllMoves() {
    String ans = "";
    for (int r=0;r<rows;r++) {
      for (int c=0;c<cols;c++) {
        ans += (allMoves[r][c]) + " ";
      }
      ans += "\n";
    }
    return ans;
  }

  //modifies the 2D array of allMoves accordingly
  public void decreaseMoves(int row, int col) {
    int checkR = 0;
    int checkC = 0;
    allMoves[row][col] = 0; //no more moves are possible if a knight is added here
    for (int i = 0; i<moves.length;i++) {
      checkR = row+moves[i][0];
      checkC = row+moves[i][1];
      if (!(checkR < 0 || checkR >= rows || checkC < 0 || checkC >= cols)) {
        allMoves[checkR][checkC] -= 1;
      }
    }
  }

}
