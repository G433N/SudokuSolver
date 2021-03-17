package com.green.sudoku;

import java.util.ArrayList;

//Class for storage of possible values and if the cell is solved
public class Cell {
	// store x and y too
	public int value;
	public int x;
	public int y;
	public ArrayList<Integer> possiblities;
	public boolean solved;
	
	
	public Cell(int value, int x, int y) {
		this.value = value;
		this.possiblities = new ArrayList<>();
		this.solved = false;
		
		for(int i = 1; i <= Sudoku.gridSize; i++) possiblities.add(i);
	}
	
	@SuppressWarnings("unchecked")
	Cell(Cell cell) { // This should make a deep copy
		this.value = cell.value;
		this.possiblities = (ArrayList<Integer>) cell.possiblities.clone();
		this.solved = cell.solved;
	}
}