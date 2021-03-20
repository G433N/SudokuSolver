package com.green.sudoku.gui;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.green.sudoku.Cell;
import com.green.sudoku.Sudoku;
import com.green.sudoku.math.ArrayLooper2D;

@SuppressWarnings("serial")
public class SudokuGUI extends Frame{
	
	/*
	 * SudokuGUI is Class that creates a grid of ElementUI
	 * with a specified size, to simulate a Sudoku sheet.
	 * It also has the function to set, get and reset the sheet.
	 * The sheet is stored as an CellGUI[][]
	 */
	
	CellGUI[][] cellGrid;
	
	public SudokuGUI(int xPos, int yPos, int emlementSize, int elementDistance, int xSize, int ySize) {
		
		final int size = Sudoku.gridSize;
		
		ArrayLooper2D a = new ArrayLooper2D(size);
		
		cellGrid = new CellGUI[size][size];
		
		for (int i = 1; i <= a.getMax(); i++) {
			
			int x = a.getX(i);
			int y = a.getY(i);
			
			cellGrid[y][x] = new CellGUI(xPos + x * elementDistance, yPos + y * elementDistance, emlementSize, x, y);
			
			add(cellGrid[y][x]);
		}
		
		// Makes the window close when pressing "x"
		addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e) {  
                dispose();  
            }  
        });  
			
		this.setSize(xSize, ySize);
		
		this.setLayout(null);
				
		this.setVisible(true);
		
		this.setTitle("Sudoku");
		
	}
	
	public void setSheet(Cell[][] cells) {
		
		final int size = Sudoku.gridSize;
		
		ArrayLooper2D a = new ArrayLooper2D(size);
		
		for (int i = 1; i <= a.getMax(); i++) {
			
			int x = a.getX(i);
			int y = a.getY(i);
			
			this.cellGrid[y][x].value = cells[y][x].value;
			this.cellGrid[y][x].setLabel(this.cellGrid[y][x].value);
		}
	}
	
	public void resetSheet() {
		
		final int size = Sudoku.gridSize;
		
		ArrayLooper2D a = new ArrayLooper2D(size);
		
		for (int i = 1; i <= a.getMax(); i++) {
			
			int x = a.getX(i);
			int y = a.getY(i);
			
			this.cellGrid[y][x].value = 0;
			this.cellGrid[y][x].setLabel(cellGrid[y][x].value);
			
		}
	}
	
	public Cell[][] getSheet() { 
		
		final int size = Sudoku.gridSize;
		
		Cell[][] result = new Cell[size][size];
		
		ArrayLooper2D a = new ArrayLooper2D(size);
		
		for (int i = 1; i <= a.getMax(); i++) {
			
			int x = a.getX(i);
			int y = a.getY(i);
			
			result[y][x] = this.cellGrid[y][x].getCell();
		}
		return result;
	}
	
}
