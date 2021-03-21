package com.green.sudoku;

import com.green.sudoku.math.ArrayLooper2D;

	/*
	 * TODO Log all move
	 * TODO Backtracking
	 * TODO Solve Sudoku
	 */
		
public class SudokuSolver {
	
	Cell[][] cells;
	Cell[][] cellsCopy;
	
	public SudokuSolver(Cell[][] sheet) {
		
		this.cells = sheet;
		
		this.initSheet();
		
		this.cellsCopy = this.getCellsCopy();
	}
	
	public void solve() {
		
		while (true) {
			this.cellsCopy = this.getCellsCopy();
			
			Cell cell = this.getFirstEmptyCell();
			
			if (cell == null) return; // Solved
			
			if (cell.possiblities.size() == 0) {
				System.out.println("Error");
				return;
			}
			
			cell.value = cell.possiblities.get(0);
			
			this.updateAllValues();
		}
		/*
		Cell temp1 = this.getFirstEmptyCell();
		Cell temp2 = this.getFirstEmptyCell(this.cellsCopy);
		
		System.out.println("X : " + temp1.x + " Y : " + temp1.y);
		System.out.println("X : " + temp2.x + " Y : " + temp2.y);
		System.out.println(temp1.possiblities);
		*/
	}
	
	private void updateAllValues() {
		
		final int size = Sudoku.gridSize;
		
		ArrayLooper2D a = new ArrayLooper2D(size);
		
		boolean solving = true;
		boolean solved = true;
		int maxLoops = 1000;
		int loops = 0;
		
		
		while (solving && loops < maxLoops) {
			
			solved = true;
			
			for (int i = 1; i <= a.getMax(); i++) {
				
				int x = a.getX(i);
				int y = a.getY(i);
				
				Cell cell = this.cells[y][x];
				
				if (cell.solved) {
					continue;
				}
				else {
					solved = false;
				}
				
				cell.updateSolved();
				this.updatePossiblities(cell);
			}
			
			if (solved) solving = false;
			loops++;
		}
	}
	
	public Cell[][] getResult() {
		return this.cells;
	}
	
 	private void updatePossiblities(Cell cell) { // TODO Change name
 		
 		int value = cell.value;
 		int x = cell.x;
 		int y = cell.y;
 		
		if (value == 0) return;
		
		for (Cell c : this.getRow(y)) {
			
			int index = c.possiblities.indexOf(value);
			
			if (index != -1) {
				
				c.possiblities.remove(index);
			}
		}
		
		for (Cell c : this.getColumn(x)) {
			
			int index = c.possiblities.indexOf(value);
			
			if (index != -1) {
				
				c.possiblities.remove(index);
			}
		}
		
		for (Cell c : this.getBox(x, y)) {
			
			int index = c.possiblities.indexOf(value);
			
			if (index != -1) {
				
				c.possiblities.remove(index);
			}
		}
	}
	
 	private Cell getFirstEmptyCell(Cell[][] cells) {
 		
		final int size = Sudoku.gridSize;
			
		ArrayLooper2D a = new ArrayLooper2D(size);
		
		for (int i = 1; i <= a.getMax(); i++) {
			
			int x = a.getX(i);
			int y = a.getY(i);
			
			if (cells[y][x].value == 0) return cells[y][x];
		}
		return null;
 	}
 	
 	private Cell getFirstEmptyCell() {
 		return this.getFirstEmptyCell(this.cells);
 	}
 	
 	private Cell[] getRow(int y) { // Takes in parameter x and returns an array with
		
		final int size = Sudoku.gridSize;
		
		Cell[] result = new Cell[size];
		
		for (int i = 0; i < size; i++) result[i] = this.cells[y][i];
		
		return result;
	}
	
	private Cell[] getColumn(int x) {
		
		final int size = Sudoku.gridSize;
		
		Cell[] result = new Cell[size];
		
		for (int i = 0; i < size; i++) result[i] = this.cells[i][x];
		
		return result;
	}
	
	private Cell[] getBox(int x, int y) {
		
		x = (int) (Math.ceil(((float)(x)+1f)/3f)); // TODO Readability
		y = (int) (Math.ceil(((float)(y)+1f)/3f));
		x = 3 * (x - 1);
		y = 3 * (y - 1);
		
		final int size = Sudoku.boxSize;
		
		ArrayLooper2D a = new ArrayLooper2D(size);
		
		Cell[] result = new Cell[a.getMax()];
		
		for (int i = 1; i <= a.getMax(); ++i) {
			
			result[i - 1] = this.cells[y + a.getY(i)][x + a.getX(i)];
		}
		return result;
	}
	
	private Cell[][] getCellsCopy() {
		
		final int size = Sudoku.gridSize;
		
		Cell[][] result = new Cell[size][size];
		
		ArrayLooper2D a = new ArrayLooper2D(size);
		
		for (int i = 1; i <= a.getMax(); ++i) {
			
			int x = a.getX(i);
			int y = a.getY(i);
			
			result[y][x] = new Cell(this.cells[y][x]);
		}
		return result;
	}
	
	private void initSheet() {
		
		final int size = Sudoku.gridSize;
		
		ArrayLooper2D a = new ArrayLooper2D(size);
		
		for (int i = 1; i <= a.getMax(); i++) {
			
			int x = a.getX(i);
			int y = a.getY(i);
			
			Cell cell = this.cells[y][x];
			
			if (cell.value != 0) cell.solved = true;
			
			this.updatePossiblities(cell);
		}
		
		this.updateAllValues();
	}
}