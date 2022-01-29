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
        
        System.out.println("Row: " + canFitRow(board, 8, 7));
        System.out.println("Col: " + canFitCol(board, 8, 1));

        System.out.println("Square: " + canFitSquare(board, 8, 0, 4));
        
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
