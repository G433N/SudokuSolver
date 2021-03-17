package com.green.sudoku;
import java.awt.*;
import java.awt.event.*;


import com.green.sudoku.gui.SudokuGUI;

	/*
	 * TODO "Roadmap"
	 * Generate button - DONE
	 * Variable for GUI distance - DONE
	 * Exit function - DONE
	 * Retractor - Done
	 * Package - Done
	 * 
	 * Brute force solving - Next Step
	 * 
	 * Make size global and static and final, no stupid dynamic size bitch
	 * Clean-up
	 * Commenting
	 * 
	 * Rule solving
	 * 
	 * U do commenting
	 */

public class Sudoku {
	
	// Data
	
	static SudokuGUI GUI;
	
	// Margin
	final static int gridSize = 9; // Use this as global later
	final static int gridXMargin = 20;
	final static int gridYMargin = 20;
	
	final static int emlementSize = 30;
	final static int elementDistance = 30;
	
	// Temporary
	
	static int[][] hardCodedSheet = {
				{3, 0, 7, 0, 0, 4, 1, 0, 0, },
				{0, 0, 0, 0, 0, 6, 7, 5, 4, },
				{0, 9, 4, 1, 0, 0, 0, 0, 3, },
				{0, 3, 0, 0, 0, 2, 0, 0, 0, },
				{0, 2, 8, 0, 0, 0, 0, 0, 1, },
				{0, 0, 6, 8, 3, 1, 0, 0, 0, },
				{2, 0, 0, 0, 0, 0, 3, 0, 7, },
				{5, 0, 1, 0, 6, 0, 4, 0, 0, },
				{0, 7, 0, 0, 0, 0, 0, 0, 6, },
			};
	
	public static void main(String[] args) {
		
		GUI = new SudokuGUI(gridSize, gridXMargin, 2 * gridYMargin, emlementSize, elementDistance, gridXMargin * 2 + gridSize * elementDistance, gridYMargin * 2 + (gridSize + 3) * elementDistance);
		
		GUI.add(buildSolveButton(gridXMargin, 3 * gridYMargin + gridSize * elementDistance, 2 * elementDistance, emlementSize));
		
		GUI.add(buildResetButton(gridXMargin + 2 * elementDistance, 3 * gridYMargin + gridSize * elementDistance, 2 * elementDistance, emlementSize));
		
		GUI.add(buildGenerateButton(gridXMargin + 4 * elementDistance, 3 * gridYMargin + gridSize * elementDistance, 2 * elementDistance, emlementSize));
	}
	
	static void solveSudoku(int[][] sheet) {
		
		SudokuSolver sudokuBruteSolver = new SudokuSolver(sheet, gridSize);
		sudokuBruteSolver.solve();
		GUI.setSheet(sudokuBruteSolver.getResult());
	}
	
	// Temporary functions
	
	static void printSudoku(int[][] sheet) {
		
		/*
		 * Temporary function for debugging.
		 * The function prints a sheet to the console.
		 */
		
		for(int[] column : sheet) {
			
			System.out.println();
			
			for(int value : column) {
				
				System.out.print(value + "");
				
			}
		}
	}
	
	// More buttons
	
	static Button buildSolveButton(int x, int y, int xSize, int ySize) {
		
		/*
		 * Function for building the "solve" button.
		 * That runs the solveSudoku function
		 */
		
		Button button = new Button("Solve");
		
		button.setBounds(x, y, xSize, ySize);  
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				solveSudoku(GUI.getSheet());
				
			}
		});
		
		return button;
	}
	
	static Button buildResetButton(int x, int y, int xSize, int ySize) {
		
		/*
		 * Function for building the "reset" button.
		 * That runs the GUI.resetSheet function
		 */
		
		Button button = new Button("Reset");
		
		button.setBounds(x, y, xSize, ySize);
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				GUI.resetSheet();
				
			}
		});
		
		return button;
	}
	
	static Button buildGenerateButton(int x, int y, int xSize, int ySize) {
		
		/*
		 * Function for building the "generate" button.
		 * That sets the sheet to the variable hardCodedSheet sheet
		 */
		
		Button button = new Button("Generate");
		
		button.setBounds(x, y, xSize, ySize);  
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				GUI.setSheet(hardCodedSheet);
				
			}
		});
		
		return button;
	}
}	