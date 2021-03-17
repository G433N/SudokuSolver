package com.green.sudoku;

import java.util.ArrayList;

//Class for storage of possible values and if the cell is solved
public class Cell {
	// store x and y too
	int value;
	ArrayList<Integer> possiblities;
	boolean solved;
	
	
	Cell(int size, int value) {
		this.value = value;
		this.possiblities = new ArrayList<>();
		this.solved = false;
		
		for(int i = 1; i <= size; i++) possiblities.add(i);
	}
	
	@SuppressWarnings("unchecked")
	Cell(Cell cell) { // This should make a deep copy
		this.value = cell.value;
		this.possiblities = (ArrayList<Integer>) cell.possiblities.clone();
		this.solved = cell.solved;
	}
}