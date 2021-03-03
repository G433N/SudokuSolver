package com.green.sudoku.math;

public class ArrayLooper2D {
	
	// loops values 1 -> size^2
	// Warning will break with n = 0;
	
	final int size;
	
	public ArrayLooper2D(int size) {
		this.size = size;	
	}
	
	public int getMax() {
		return this.size * this.size;
	}
	
	public int getX(int n) {
		return (n - 1) % this.size;
	}
	
	public int getY(int n) {
		return (int) (Math.ceil(n / (float) this.size) - 1) % this.size;
	}
}