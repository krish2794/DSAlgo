package org.example.backtrack;

import java.util.Deque;
import java.util.LinkedList;

public class KnightTour {

    private final int N = 8;

    public static void main(String[] args){
        KnightTour knightTour = new KnightTour();
        knightTour.solveKT();
    }

    private void solveKT() {
        int[][] board = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                board[i][j]=-1;
            }
        }

        board[0][0] = 0;
        Deque<Pair> deque = new LinkedList<>();
        deque.add(new Pair(0,0));
        int[] xMove = {-2,-2,-1,-1,1,1,2,2};
        int[] yMove = {-1,1,-2,2,-2,2,-1,1};

        if(solveKTUtil(board, 0, 0, 1, xMove, yMove, deque)){
            printBoard(board);
            printPositions(deque);

        }else {
            System.out.println("No Solution");
        }
    }

    private void printPositions(Deque<Pair> deque){
        while(!deque.isEmpty()){
            System.out.print(deque.poll() + " ");
        }
    }
    private void printBoard(int[][] board) {
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(board[i][j]+ " ");
            }
            System.out.println();
        }
    }

    private boolean solveKTUtil(int[][] board, int x, int y, int move, int[] xMove, int[] yMove, Deque<Pair> deque){
        if(move == N*N)
            return true;

        int k, x_nextMove, y_nextMove;
        for(k=0;k<8;k++){
            x_nextMove = x + xMove[k];
            y_nextMove = y + yMove[k];

            if(isSafe(board, x_nextMove, y_nextMove)){
                board[x_nextMove][y_nextMove] = move;
                deque.add(new Pair(x_nextMove, y_nextMove));
                if(solveKTUtil(board, x_nextMove, y_nextMove, move+1, xMove, yMove, deque)){
                    return true;
                }
                board[x_nextMove][y_nextMove] = -1;
                deque.removeLast();
            }
        }
        return false;
    }

    private boolean isSafe(int[][] board, int x, int y){
        return (x>=0 && x<N && y>=0 && y<N && board[x][y] == -1);
    }
}

class Pair {
    int x;
    int y;

    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return "("+this.x+","+this.y+")";
    }
}