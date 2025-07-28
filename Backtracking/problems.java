//                                  Subset Problem
public class problems{
    public static void findSubset(String str,String ans, int i){
        // base case
        if(i == str.length()){
            if(ans.length()==0){
                System.out.print("null");
            }else{
                System.out.println(ans);
            }
            return;
        }
        // recursion 
        // Yes
        findSubset(str, ans+str.charAt(i), i+1);
        //no
        findSubset(str, ans, i+1);
    }
    //                                Permutation Problem
    public static void findPermutation(String str , String ans){
        // base case
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }

        // recursion
        for(int i = 0; i<str.length(); i++){
            // current element ko pick kiya 
            char curr = str.charAt(i);
            // removing that character from original string
            String newStr = str.substring(0, i) + str.substring(i+1);
            findPermutation(newStr, ans+curr);
        }

    }
    //                                   N-Queen Problem

    public static boolean isSafe(char board[][], int row, int col){
        // vertical up
        for(int i = row-1; i>=0; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        // diagonal left
        for(int i = row-1, j = col-1; i>=0 && j>=0; i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        // diagonal right
        for(int i = row-1, j = col+1; i>=0 && j<board.length;i--,j++){
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
    /* 
    public static void nQueens(char board[][], int row){
        // base case 
        if(row == board.length){
            //printBoard(board);
            count++;
            return;
        }
        // column loop
        for(int j = 0; j<board.length;j++){
            if(isSafe(board,row,j)){
                board[row][j] = 'Q';
                nQueens(board, row+1);
                board[row][j] = 'X';
            }
        }
    }
     */
    
    public static boolean nQueens(char board[][], int row){
        // base case 
        if(row == board.length){
            //printBoard(board);
            count++;
            return true;
        }
        // column loop
        for(int j = 0; j<board.length;j++){
            if(isSafe(board,row,j)){
                board[row][j] = 'Q';
                if (nQueens(board, row+1)) {
                    return true;   
                } else
                board[row][j] = 'X';
            }
        }
        return false;
    }
    
    public static void printBoard(char board[][]){
        System.out.println("------------------------------");
        for(int i = 0; i < board.length;i++){
            for(int j = 0; j<board.length;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    static int count = 0;

    public static int gridWay(int i, int j, int n, int m){
        // base case
        if(i ==n-1 && j == m-1){
            return 1;
        }
        else if(i ==n || j ==m){
            return 0;
        }
        int w1 = gridWay(i, j+1, n, m);
        int w2 = gridWay(i+1, j, n, m);
        return w1+w2;
    }

    public static void ratMaze(boolean[][] board, String ans, int i, int j){
        // base case
        if(i == board.length-1 && j == board[0].length-1){
            System.out.println(ans);
            return;
        }
        // recursion
        // if we hit the blockage tile
        if(!board[i][j]){
            return;
        }
        if(i< board.length -1){
            ratMaze(board, ans+ 'D', i+1, j);
        }

        if(j< board[0].length -1){
            ratMaze(board, ans+'R', i, j+1);
        }
    }


    public static boolean isSafe(int[][] sudoku, int row, int col, int digit) {
        // Column check
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == digit) {
                return false;
            }
        }

        // Row check
        for (int j = 0; j < 9; j++) {
            if (sudoku[row][j] == digit) {
                return false;
            }
        }

        // Subgrid (3x3 grid) check
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (sudoku[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }

    // Recursive function to solve the sudoku
    public static boolean sudokuSolver(int[][] sudoku, int row, int col) {
        // Base case: if row reaches 9, sudoku is solved
        if (row == 9) {
            return true;
        }

        // Move to the next row if column reaches 9
        int nextRow = row, nextCol = col + 1;
        if (col == 8) {  // When column reaches the end
            nextRow = row + 1;
            nextCol = 0;
        }

        // If the current cell is already filled, skip it
        if (sudoku[row][col] != 0) {
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        // Try placing digits from 1 to 9
        for (int digit = 1; digit <= 9; digit++) {
             // nested if else 
            if (isSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;  // Place digit

                if (sudokuSolver(sudoku, nextRow, nextCol)) {
                    return true;
                }

                // Backtrack if no solution is found
                sudoku[row][col] = 0;
            }
        }

        // If no valid digit can be placed, return false
        return false;
    }

    public static void printBoard(int sudoku[][]){
        for(int i= 0; i<9; i++){
            for(int j = 0 ; j<9;j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[]args){
       int sudoku[][] = {
         {0,0,8,0,0,0,0,0,0},
         {4,9,0,1,5,7,0,0,2},
         {0,0,3,0,0,4,1,9,0},
         {1,8,5,0,6,0,0,2,0},
         {0,0,0,0,2,0,0,6,0},
         {9,6,0,4,0,5,3,0,0},
         {0,3,0,0,7,2,0,0,4},
         {0,4,9,0,3,0,0,5,7},
         {8,2,7,0,0,9,0,1,3}
       };
       if(sudokuSolver(sudoku, 0, 0)){
        System.out.println("Solution exist");
        System.out.println("-------------------------");
        printBoard(sudoku);
        System.out.println("-------------------------");
       }
       else{
        System.out.println("Solution does not exist");
       }
       /* 
       int n = 2;
       char board[][] = new char[n][n];
       // initialize
       for(int i = 0; i< n ;i++){
        for(int j = 0; j< n ;j++){
           System.out.print(board[i][j] = 'X');
        }
        System.out.println();
       }
       nQueens(board, 0);
       System.out.print("total ways of n queen is : "+ count);
       */

      /*
      int n = 3;
      int m = 3;
      System.out.print("Total number of ways is: "+gridWay(0, 0,n,m));
       */
      /*
      boolean [][] board = {
           {true,true,true},
           {true,false,true},
           {true,true,true}
      };
      int i = 0;
      int j = 0;
      String ans = "";
      ratMaze(board,ans,i,j);
       */
    }
}