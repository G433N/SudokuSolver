package com.green.sudoku.solvers;

import com.green.sudoku.math.IntVector2;

public class SudokuOldSolver {

    int[][] sudoku; // First is y second is x;

    private final static int[] VALUES = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private final static int[] X_VALUES = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
    private final static int[] Y_VALUES = {-1, -1, -1, 0, 0, 0, 1, 1, 1};

    public SudokuOldSolver(int[][] sudoku) {
        this.sudoku = sudoku;
    }


    // Setter and Getters
    public void setValue(int x, int y, int newValue) {
        this.sudoku[y - 1][x - 1] = newValue;
    }

    public int getValue(int x, int y) {
        return this.sudoku[y - 1][x - 1];
    }

    public int[] getRow(int y) {
        return this.sudoku[y-1];
    }

    public int[] getColumn(int x) {
        int[] column = new int[9];
        for (int i = 0; i < column.length; i++) {
            column[i] = this.sudoku[i][x - 1];
        }
        return column;
    }

    public int[] getQuadrant(int x, int y) {
        int[] result = new int[9];

        x = 3 * x - 2;
        y = 3 * y - 2;

        for (int i = 0; i < result.length; i++) {
            result[i] = this.sudoku[y + Y_VALUES[i]][x + X_VALUES[i]];
        }

        return result;
    }

    public IntVector2[] getQuadrantEmptySpaces(int x, int y) { // If return == null quadrant full
        int[] quadrant = this.getQuadrant(x, y);
        IntVector2[] result = new IntVector2[quadrant.length];

        x = 3 * x - 2;
        y = 3 * y - 2;

        int l = 0;

        for (int i = 0; i < result.length; i++) {
            if (quadrant[i] == 0) {
                result[i] = new IntVector2(x + X_VALUES[i] + 1, y + Y_VALUES[i] + 1);
                l++;
            }
            else {
                result[i] = null;
            }
        }
        if (l == 0) return null;

        return arrayRemoveNull(result);
    }

    public int[] getRowEmptySpaces(int y, int value) {
        int[] row = this.getRow(y);
        int[] result = new int[row.length];

        int l = 0;

        int quadrantY = (int) Math.ceil((float)y / 3f);

        for(int x = 0; x < row.length; x++) {

            int quadrantX = (int) Math.ceil((float)(x + 1) / 3f);
            boolean b = true;

            for (int r : row) {
                if (r == value) {
                    b = false;
                }
            }

            if ( this.getValue(x+1, y) == 0) {

                int[] quadrant = this.getQuadrant(quadrantX, quadrantY);
                for (int q : quadrant) {
                    if (q == value) {
                        b = false;
                    }
                }
                if (b) {
                    result[x] = x + 1;
                    l++;
                }
                else {
                    result[x] = 0;
                }
            }
            else {
                result[x] = 0;
            }

        }

        if(l == 0) return null;

        return arrayRemoveZero(result);
    }

    private int[] getColumnEmptySpaces(int x, int value) {
        int[] column = this.getColumn(x);
        int[] result = new int[column.length];

        int l = 0;

        int quadrantX = (int) Math.ceil((float)x / 3f);

        for(int y = 0; y < column.length; y++) {

            int quadrantY = (int) Math.ceil((float)(y + 1) / 3f);

            boolean b = true;

            for (int c : column) {
                if (c == value) {
                    b = false;
                }
            }

            if ( this.getValue(x, y + 1) == 0) {

                int[] quadrant = this.getQuadrant(quadrantX, quadrantY);
                for (int q : quadrant) {
                    if (q == value) {
                        b = false;
                    }
                }
                if (b) {
                    result[y] = y + 1;
                    l++;
                }
                else {
                    result[y] = 0;
                }
            }
            else {
                result[y] = 0;
            }

        }

        if(l == 0) return null;

        return arrayRemoveZero(result);
    }

    // Solving
    public void solve() {
        boolean solving = true;
        int maxTries = 100000;
        int tries = 0;

        while (solving) {
            tries++;
            int x = 1;
            int y = 1;

            for (int n = 0; n < 3 * 3; n++) {
                this.solveQuadrant(x, y);
                if (x == 3) {

                    x = 0;
                    y++;
                }
                x++;
            }

            for (int n = 1; n < 9; n++) {
                this.solveRow(n);
                this.solveColumn(n);
            }
            x = 1;
            y = 1;
            boolean stop = true;

            for (int n = 0; n < 3 * 3; n++) {
                boolean empty = SudokuOldSolver.getMissingValuesArray(this.getQuadrant(x, y)).length == 0;
                if(!empty) stop = false;

                if (x == 3) {
                    x = 0;
                    y++;
                }
                x++;
            }

            if (stop || maxTries < tries) solving = false;
        }
    }

    public void solveQuadrant(int x, int y) {
        int[] missingValues = getMissingValuesArray(this.getQuadrant(x, y));

        for (int value : missingValues) {
            IntVector2[] possibleSpaces = this.getQuadrantEmptySpaces(x, y);

            for (int i = 0; i < possibleSpaces.length; i++) {

                boolean stillPossible = true;

                for (int n : this.getRow(possibleSpaces[i].y)) {
                    if (n == value) {
                        stillPossible = false;
                    }
                }

                for (int n : this.getColumn(possibleSpaces[i].x)) {
                    if (n == value) {
                        stillPossible = false;
                    }
                }

                if (!stillPossible) {
                    possibleSpaces[i] = null;
                }
            }
            possibleSpaces = arrayRemoveNull(possibleSpaces);

            if (possibleSpaces != null) {
                if (possibleSpaces.length == 1) {
                    this.setValue(possibleSpaces[0].x, possibleSpaces[0].y, value);
                }
            }
        }
    }

    public void solveRow(int y) {
        int[] missingValues = getMissingValuesArray(this.getRow(y));

        for (int value : missingValues) {
            int[] possibleSpaces = this.getRowEmptySpaces(y, value);
            if (possibleSpaces == null) break;
            for (int i = 0; i < possibleSpaces.length; i++) {
                boolean stillPossible = true;

                for (int n : this.getColumn(possibleSpaces[i])) {
                    if (n == value) {
                        stillPossible = false;
                    }
                }

                if (!stillPossible) {
                    possibleSpaces[i] = 0;
                }
            }
            possibleSpaces = arrayRemoveZero(possibleSpaces);

            if (possibleSpaces != null) {
                if (possibleSpaces.length == 1) {
                    this.setValue(possibleSpaces[0], y, value);
                }
            }
        }
    }

    public void solveColumn(int x) {
        int[] missingValues = getMissingValuesArray(this.getColumn(x));

        for (int value : missingValues) {
            int[] possibleSpaces = this.getColumnEmptySpaces(x, value);
            if (possibleSpaces == null) break;
            for (int i = 0; i < possibleSpaces.length; i++) {
                boolean stillPossible = true;

                for (int n : this.getRow(possibleSpaces[i])) {
                    if (n == value) {
                        stillPossible = false;
                    }
                }

                if (!stillPossible) {
                    possibleSpaces[i] = 0;
                }
            }
            possibleSpaces = arrayRemoveZero(possibleSpaces);

            if (possibleSpaces != null) {
                if (possibleSpaces.length == 1) {
                    this.setValue(x, possibleSpaces[0], value);
                }
            }
        }
    }

    // Static
    public static int[] getValuesArray(int[] array) {

        String text = "";

        for (int i : array) {
            if (i != 0) {
                text += i;
            }
        }

        char[] chars = text.toCharArray();
        int[] result = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            result[i] = Integer.parseInt(String.valueOf(chars[i]));
        }

        return result;
    }

    public static int[] getMissingValuesArray(int[] array) {
        int[] result = VALUES.clone();

        for (int n : array) {
            if (n != 0 ){
                result[n - 1] = 0;
            }
        }

        return getValuesArray(result);
    }

    private static int[] arrayRemoveZero(int[] array) {
        int l = 0;
        for (int v : array) {
            if(v != 0) l++;
        }
        if (l == 0) return null;
        int[] result = new int[l];
        int i = 0;
        for (int v : array) {
            if(v != 0) {
                result[i] = v;
                i++;
            }
        }
        return result;
    }

    private static IntVector2[] arrayRemoveNull(IntVector2[] array) {
        int l = 0;
        for (IntVector2 v : array) {
            if(v != null) l++;
        }
        if (l == 0) return null;
        IntVector2[] result = new IntVector2[l];
        int i = 0;
        for (IntVector2 v : array) {
            if(v != null) {
                result[i] = v;
                i++;
            }
        }
        return result;
    }

    // UI
    public String getString() {
        String text = "";
        for (int[] b : this.sudoku) {
            for (int n : b) {
                text += n + " ";
            }
            text += "\n";
        }
        return text;
    }

    public void print() {
        System.out.println(this.getString());
    }
}