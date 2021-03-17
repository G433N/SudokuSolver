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
	
	ElementGUI[] elements;
	
	public SudokuGUI(int gridSize, int x, int y, int emlementSize, int elementDistance, int xSize, int ySize) {
		
		this.size = gridSize;
		
		ArrayLooper2D a = new ArrayLooper2D(this.size);
		
		elements = new ElementGUI[a.getMax()];
		
		for (int i = 1; i <= a.getMax(); i++) {
			
			elements[i - 1] = new ElementGUI(x + a.getX(i) * elementDistance, y + a.getY(i) * elementDistance, emlementSize);
			
			add(elements[i - 1]);
		}
		
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
			
			this.elements[i - 1].num = elements[a.getY(i)][a.getX(i)];
			
			this.elements[i - 1].setLabel(this.elements[i - 1].num);
		}
		
	}
	
	public void resetSheet() {
		
		for (int i = 0; i < elements.length; i++) {
			
			this.elements[i].num = 0;
			this.elements[i].setLabel(elements[i].num);
			
		}
	}
	
	public int[][] getSheet() { 
		
		int[][] result = new int[this.size][size];
		
		ArrayLooper2D a = new ArrayLooper2D(this.size);
		
		for (int i = 1; i <= a.getMax(); i++) {
			
			result [a.getY(i)][a.getX(i)] = this.elements[i - 1 ].num;
			
		}
		
		return result;
	}
	
}
