package com.green.sudoku.gui;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.green.sudoku.math.ArrayLooper2D;

@SuppressWarnings("serial")
public class SudokuGUI extends Frame{
	
	/*
	 * SudokuGUI is Class that creates a grid of ElementUI
	 * with a specified size, to simulate a Sudoku sheet.
	 * It also has the function to set, get and reset the sheet.
	 * The sheet is stored as an int[][]
	 */
	
	final int size;
	
	CellGUI[] cellGrid;
	
	public SudokuGUI(int gridSize, int x, int y, int emlementSize, int elementDistance, int xSize, int ySize) {
		
		this.size = gridSize;
		
		ArrayLooper2D a = new ArrayLooper2D(this.size);
		
		cellGrid = new CellGUI[a.getMax()];
		
		for (int i = 1; i <= a.getMax(); i++) {
			
			cellGrid[i - 1] = new CellGUI(x + a.getX(i) * elementDistance, y + a.getY(i) * elementDistance, emlementSize);
			
			add(cellGrid[i - 1]);
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
	
	public void setSheet(int[][] elements) {
		
		ArrayLooper2D a = new ArrayLooper2D(this.size);
		
		for (int i = 1; i <= a.getMax(); i++) {
			
			this.cellGrid[i - 1].num = elements[a.getY(i)][a.getX(i)];
			
			this.cellGrid[i - 1].setLabel(this.cellGrid[i - 1].num);
		}
		
	}
	
	public void resetSheet() {
		
		for (int i = 0; i < cellGrid.length; i++) {
			
			this.cellGrid[i].num = 0;
			this.cellGrid[i].setLabel(cellGrid[i].num);
			
		}
	}
	
	public int[][] getSheet() { 
		
		int[][] result = new int[this.size][size];
		
		ArrayLooper2D a = new ArrayLooper2D(this.size);
		
		for (int i = 1; i <= a.getMax(); i++) {
			
			result [a.getY(i)][a.getX(i)] = this.cellGrid[i - 1 ].num;
			
		}
		
		return result;
	}
	
}
