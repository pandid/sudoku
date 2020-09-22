package com.georgi.georgiev.sudoku;

import java.util.BitSet;

// Using bitsets so quite a bit less memory
// Ignoring the overhead of object header, the array
// elements of boolean are consuming 1024 bytes,
// instead of the  1024 bits for bit array used here.

public class SudokuValidatorBitSet implements SudokuValidator {
    public boolean isValidSudoku(int[][] board) {
        //Check rows and columns same time - less time
        for (int i = 0; i < board.length; i++) {
            BitSet bsRow = new BitSet(9);
            BitSet bsColumn = new BitSet(9);
            for (int j = 0; j < board[i].length; j++) {
                //handle raw and column cases separately
                if (board[i][j] != 0 ) {
                    if (bsRow.get(board[i][j] - 1)) {
                        return false;
                    } else {
                        bsRow.set(board[i][j] - 1);
                    }
                }
                //handle cases separately ||
                if (board[j][i] != 0 ) {
                    if (bsColumn.get(board[j][i] - 1)) {
                        return false;
                    } else {
                        bsColumn.set(board[j][i] - 1);
                    }
                }
            }
        }

        //Check within 3 x 3 grid
        for (int rowOffset = 0; rowOffset < 9; rowOffset += 3) {
            for (int columnOffset = 0; columnOffset < 9; columnOffset += 3) {
                BitSet threeByThree = new BitSet(9);
                for (int i = rowOffset; i < rowOffset + 3; i++) {
                    for (int j = columnOffset; j < columnOffset + 3; j++) {
                        if (board[i][j] == 0) continue;
                        if (threeByThree.get(board[i][j] - 1))
                            return false;
                        else
                            threeByThree.set(board[i][j] - 1);
                    }
                }
            }
        }
        return true;
    }
}
