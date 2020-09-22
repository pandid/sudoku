package com.georgi.georgiev.sudoku;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TestSudoku {

    int[][] VALID_SUDOKU1  = {
            { 5,3,0,0,7,0,0,0,0 },
            { 6,0,0,1,9,5,0,0,0 },
            { 0,9,8,0,0,0,0,6,0 },
            { 8,0,0,0,6,0,0,0,3 },
            { 4,0,0,8,0,3,0,0,1 },
            { 7,0,0,0,2,0,0,0,6 },
            { 0,6,0,0,0,0,2,8,0 },
            { 0,0,0,4,1,9,0,0,5 },
            { 0,0,0,0,8,0,0,7,9 }
    };

    //Two 8's in the top left 3x3 sub-box, it is invalid.
    int[][] INVALID_SUDOKU_BLOCK  = {
            { 8,3,0,0,7,0,0,0,0 },
            { 6,0,0,1,9,5,0,0,0 },
            { 0,9,8,0,0,0,0,6,0 },
            { 8,0,0,0,6,0,0,0,3 },
            { 4,0,0,8,0,3,0,0,1 },
            { 7,0,0,0,2,0,0,0,6 },
            { 0,6,0,0,0,0,2,8,0 },
            { 0,0,0,4,1,9,0,0,5 },
            { 0,0,0,0,8,0,0,7,9 }
    };

    // Two 7's in the first row, it is invalid.
    int[][] INVALID_SUDOKU_ROW  = {
            { 5,3,0,0,7,0,0,7,0 },
            { 6,0,0,1,9,5,0,0,0 },
            { 0,9,8,0,0,0,0,6,0 },
            { 8,0,0,0,6,0,0,0,3 },
            { 4,0,0,8,0,3,0,0,1 },
            { 7,0,0,0,2,0,0,0,6 },
            { 0,6,0,0,0,0,2,8,0 },
            { 0,0,0,4,1,9,0,0,5 },
            { 0,0,0,0,8,0,0,7,9 }
    };

    // Two 8's in the first column
    int[][] INVALID_SUDOKU_COLUMN  = {
            { 5,3,0,0,7,0,0,0,0 },
            { 6,0,0,1,9,5,0,0,0 },
            { 0,9,8,0,0,0,0,6,0 },
            { 8,0,0,0,6,0,0,0,3 },
            { 4,0,0,8,0,3,0,0,1 },
            { 7,0,0,0,2,0,0,0,6 },
            { 8,6,0,0,0,0,2,8,0 },
            { 0,0,0,4,1,9,0,0,5 },
            { 0,0,0,0,8,0,0,7,9 }
    };

    List<int[][]> invalid;
    List<int[][]>  valid;
    List<SudokuValidator> validators;

    @Before
    public void initialize() {
        invalid = new LinkedList();
        invalid.add(INVALID_SUDOKU_ROW);
        invalid.add(INVALID_SUDOKU_COLUMN);
        invalid.add(INVALID_SUDOKU_BLOCK);

        valid = new LinkedList();
        valid.add(VALID_SUDOKU1);

        validators = new LinkedList<SudokuValidator>();
        validators.add(new SudokuValidatorArray());
        validators.add(new SudokuValidatorBitSet());
    }

    @Test
    public void testValidSudoku(){
        for (SudokuValidator validator:
                validators) {
            for (int[][] testSudokuCase:
                    valid) {
                assertTrue(validator.isValidSudoku(testSudokuCase));
            }
        }
    }

    @Test
    public void testInvalidSudoku(){
        for (SudokuValidator validator:
                validators) {
            for (int[][] testSudokuCase:
                 invalid) {
                assertFalse(validator.isValidSudoku(testSudokuCase));
            }
        }
    }
}
