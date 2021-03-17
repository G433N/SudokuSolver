package com.green.sudoku.gui;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.green.sudoku.Cell;
import com.green.sudoku.math.ArrayLooper2D;

@SuppressWarnings("serial")
public class SudokuGUI extends Frame{
	
	/*
	 * SudokuGUI is Class that creates a grid of ElementUI
	 * with a specified size, to simulate a Sudoku sheet.
	 * It also has the function to set, get and reset the sheet.
	 * The sheet is stored as an CellGUI[][]
	 */
	
	final int size;
	
	CellGUI[][] cellGrid;
	
	public SudokuGUI(int gridSize, int x, int y, int emlementSize, int elementDistance, int xSize, int ySize) {
		
		this.size = gridSize;
		
		ArrayLooper2D a = new ArrayLooper2D(this.size);
		
		cellGrid = new CellGUI[this.size][this.size];
		
		for (int i = 1; i <= a.getMax(); i++) {
			
			cellGrid[a.getY(i)][a.getX(i)] = new CellGUI(x + a.getX(i) * elementDistance, y + a.getY(i) * elementDistance, emlementSize, a.getX(i), a.getY(i));
			
			add(cellGrid[a.getY(i)][a.getX(i)]);
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
		
		ArrayLooper2D a = new ArrayLooper2D(this.size);
		
		for (int i = 1; i <= a.getMax(); i++) {
			
			this.cellGrid[a.getY(i)][a.getX(i)].num = cells[a.getY(i)][a.getX(i)].value;
			
			this.cellGrid[a.getY(i)][a.getX(i)].setLabel(this.cellGrid[a.getY(i)][a.getX(i)].num);
		}
	}
	
	public void resetSheet() {
		
		ArrayLooper2D a = new ArrayLooper2D(this.size);
		
		for (int i = 1; i <= a.getMax(); i++) {
			
			this.cellGrid[a.getY(i)][a.getX(i)].num = 0;
			this.cellGrid[a.getY(i)][a.getX(i)].setLabel(cellGrid[a.getY(i)][a.getX(i)].num);
			
		}
	}
	
	public Cell[][] getSheet() { 
		
		Cell[][] result = new Cell[this.size][size];
		
		ArrayLooper2D a = new ArrayLooper2D(this.size);
		
		for (int i = 1; i <= a.getMax(); i++) {
			
			result [a.getY(i)][a.getX(i)] = this.cellGrid[a.getY(i)][a.getX(i)].getCell();
		}
		
		return result;
	}
	
}
