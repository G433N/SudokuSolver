package com.green.sudoku.math;
public class IntVector2 {

    public int x;
    public int y;

    public IntVector2() {
        this.x = 0;
        this.y = 0;
    }

    public IntVector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public IntVector2(IntVector2 v) {
        this.x = 0;
        this.y = 0;
        this.x += v.x;
        this.y += v.y;
    }

    public String getString() {
        return "X : " + this.x + " Y : " + this.y;
    }

    public boolean equals(IntVector2 v) {
        if (this.x == v.x && this.y == v.y) {
            return true;
        }
        return false;
    }

}
