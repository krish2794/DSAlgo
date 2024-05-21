package org.example.backtrack;

public class SudokuSolver {

    public static void main(String[] args){
        int[][] board = {{3,1,4,6,0,0,0,5,0},
                {5,0,9,3,7,0,0,6,0},
                {0,0,7,1,0,9,0,3,0},
                {0,0,2,8,0,0,3,0,0},
                {6,0,0,4,0,5,0,0,1},
                {0,0,1,0,0,2,5,0,0},
                {0,7,0,9,0,6,2,0,0},
                {0,2,0,0,8,7,6,0,4},
                {0,9,0,0,0,3,8,7,5}};

        SudokuSolver sudokuSolver = new SudokuSolver();
        sudokuSolver.solveSudoku(board, board.length);

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }

    }

   private boolean solveSudoku(int[][] board,int len){
        int row = -1;
        int col = -1;
        boolean isFull = true;
        for(int i=0;i<len; i++){
            for(int j=0;j<len;j++){
                if(board[i][j] == 0){
                    row = i;
                    col = j;
                    isFull = false;
                }
                if(!isFull){
                    break;
                }
            }
        }

        if(isFull){
            return true;
        }

        for(int num=1;num<=len;num++){
            if(isSafe(board, row, col, num)){
                board[row][col] = num;
                if(solveSudoku(board, len)){
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }

    private boolean isSafe(int[][] board, int row, int col, int num){
        int len = board.length;
        for(int i=0;i<len;i++){
            if(board[row][i] == num){
                return false;
            }
        }

        for(int i=0;i<len;i++){
            if(board[i][col] == num){
                return false;
            }
        }

        int squareRoot = (int)Math.sqrt(len);
        int rowStart = row - row % squareRoot;
        int colStart = col - col % squareRoot;

        for(int i=rowStart; i<rowStart+squareRoot; i++){
            for(int j=colStart; j<colStart+squareRoot; j++){
                if(board[i][j] == num){
                    return false;
                }
            }
        }
        return true;
    }
}
