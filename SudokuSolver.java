public class SudokuSolver {

    public static void main(String args[]) {

        int[][] board = {
                { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
                { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
                { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
                { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
                { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
                { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
                { 0, 9, 0, 0, 0, 0, 4, 0, 0 }
        };
        
        solveSudoku(board);
        System.out.println();
        
    }

    public static boolean solveSudoku(int[][]board){
        //Loop through the entire grid
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {

                //Check for 0s. 0s are blank spots
                if (board[x][y] == 0){

                    //Attempt to fill the blank with 1 through board.length+1 until success
                    for (int n=1; n<board.length+1; n++){

                        //
                        if (numberIsValid(board, n, x, y)){
                            board[x][y] = n;
                            if (solveSudoku(board)){
                                break;
                            } else {
                                board[x][y] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        System.out.println("Solved Board");
        printBoard(board);
        return true;
    }

    public static void printBoard(int[][]board){
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                System.out.print(board[x][y] + " ");
            }
            System.out.println();
        }
    }

    public static boolean numberIsValid(int[][]board, int number, int row, int col){
        return canFitRow(board, number, row) 
            && canFitCol(board, number, col)
            && canFitSquare(board, number, row, col);
    }
    public static boolean canFitRow(int[][] board, int number, int row) {
        for (int x = 0; x < board.length; x++) {
            if (board[row][x] == number){
                return false;
            }
        }
        return true;
    }

    public static boolean canFitCol(int[][] board, int number, int col) {
        for (int x = 0; x < board[0].length; x++) {
            if (board[x][col] == number){
                return false;
            }
        }
        return true;
    }

    public static boolean canFitSquare(int[][] board, int number, int row, int col) {
        int firstRow = row - (row % 3);
        int firstCol = col - (col % 3);
        
        for (int x = firstRow; x < firstRow + 3; x++){
            for (int y = firstCol; y < firstCol + 3; y++){
                if (board[x][col] == number){
                    return false;
                }
            }
        }
        return true;
    }


}
