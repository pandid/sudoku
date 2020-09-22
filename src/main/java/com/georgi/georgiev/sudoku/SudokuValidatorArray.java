package com.georgi.georgiev.sudoku;

public class SudokuValidatorArray implements SudokuValidator {

    public boolean isValidSudoku(int[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9)
            return false;
        // check each column N
        //N*M
        for (int i = 0; i < 9; i++) {
            boolean[] m = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != 0) {
                    if (m[(board[i][j] - 1)]) {
                        return false;
                    }
                    m[(board[i][j] - 1)] = true;
                }
            }
        }

        //check each row - M
        //M*N
        for (int j = 0; j < 9; j++) {
            boolean[] m = new boolean[9];
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != 0) {
                    if (m[(board[i][j] - 1)]) {
                        return false;
                    }
                    m[(board[i][j] - 1)] = true;
                }
            }
        }

        //check each 3*3 matrix
        // Block*3*3
        for (int block = 0; block < 9; block++) {
            boolean[] m = new boolean[9];
            for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
                for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
                    if (board[i][j] != 0) {
                        if (m[(board[i][j] - 1)]) {
                            return false;
                        }
                        m[(board[i][j] - 1)] = true;
                    }
                }
            }
        }

        return true;
    }
}
