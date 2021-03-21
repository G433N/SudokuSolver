package com.green.sudoku;
import java.awt.*;
import java.awt.event.*;


import com.green.sudoku.gui.SudokuGUI;
import com.green.sudoku.math.ArrayLooper2D;

public class Sudoku {
	
	// Data
	
	static SudokuGUI GUI;
	
	// Margin
	public final static int gridSize = 9;
	public final static int boxSize = 3;
	
	private final static int gridXMargin = 20;
	private final static int gridYMargin = 20;
	
	private final static int cellSize = 30;
	private final static int cellDistance = 30;
	
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
		
		GUI = new SudokuGUI(gridXMargin, 2 * gridYMargin, cellSize, cellDistance, gridXMargin * 2 + gridSize * cellDistance, gridYMargin * 2 + (gridSize + 3) * cellDistance);
		
		GUI.add(buildSolveButton(gridXMargin, 3 * gridYMargin + gridSize * cellDistance, 2 * cellDistance, cellSize));
		
		GUI.add(buildResetButton(gridXMargin + 2 * cellDistance, 3 * gridYMargin + gridSize * cellDistance, 2 * cellDistance, cellSize));
		
		GUI.add(buildGenerateButton(gridXMargin + 4 * cellDistance, 3 * gridYMargin + gridSize * cellDistance, 2 * cellDistance, cellSize));
	}
	
	static void solveSudoku(Cell[][] sheet) {
		
		SudokuSolver sudoku = new SudokuSolver(sheet);
		sudoku.solve();
		GUI.setSheet(sudoku.getResult());
		sudoku.writeLog();
	}
	
	// Temporary functions
	
	static Cell[][] getHardCodedSheet() {
		
		int size = gridSize;
		ArrayLooper2D a = new ArrayLooper2D(size);
		Cell[][] result = new Cell[size][size];
		
		for (int i = 1; i <= a.getMax(); i++) {
			
			int x = a.getX(i);
			int y = a.getY(i);
			
			result[y][x] = new Cell(hardCodedSheet[y][x], x, y);
		}
		return result;
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
				
				GUI.setSheet(getHardCodedSheet());
				
			}
		});
		
		return button;
	}
}	