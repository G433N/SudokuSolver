import java.awt.*;
import java.awt.event.*;

	/*
	 * TODO
	 * Generate button - DONE
	 * Variable for GUI distance - DONE
	 * Exit function - DONE
	 * 
	 * Brute force solving
	 * 
	 * Fancy solving
	 * 
	 * Research Sudoku theory 
	 * 
	 */

public class Sudoku {
	
	static SheetGUI GUI;
	
	final static int gridSize = 9;
	final static int gridXMargin = 20;
	final static int gridYMargin = 20;
	
	final static int emlementSize = 30;
	final static int elementDistance = 30;
	
	static int[][] hardCodedSheet = {
				{0, 9, 6, 2, 0, 8, 0, 7, 5, },
				{2, 0, 0, 7, 5, 3, 0, 1, 0, },
				{0, 5, 0, 0, 0, 6, 0, 0, 2, },
				{0, 7, 0, 0, 3, 1, 0, 9, 0, },
				{0, 0, 0, 0, 0, 0, 5, 2, 0, },
				{5, 0, 0, 0, 2, 0, 1, 6, 3, },
				{0, 1, 0, 9, 0, 0, 0, 3, 0, },
				{0, 0, 3, 0, 8, 0, 2, 0, 9, },
				{9, 0, 0, 3, 7, 4, 6, 0, 1, },
			};
	
	
	public static void main(String[] args) {
		
		GUI = new SheetGUI(gridSize, gridXMargin, 2 * gridYMargin, emlementSize, elementDistance, gridXMargin * 2 + gridSize * elementDistance, gridYMargin * 2 + (gridSize + 3) * elementDistance);
		
		GUI.add(buildSolveButton(gridXMargin, 3 * gridYMargin + gridSize * elementDistance, 2 * elementDistance, emlementSize));
		
		GUI.add(buildResetButton(gridXMargin + 2 * elementDistance, 3 * gridYMargin + gridSize * elementDistance, 2 * elementDistance, emlementSize));
		
		GUI.add(buildGenerateButton(gridXMargin + 4 * elementDistance, 3 * gridYMargin + gridSize * elementDistance, 2 * elementDistance, emlementSize));
	}

	
	static Button buildSolveButton(int x, int y, int xSize, int ySize) {
		
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
		
		Button button = new Button("Reset");
		
		button.setBounds(x, y, xSize, ySize);
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				GUI.resetSheet();
				System.out.println("Reset");
				
			}
		});
		
		return button;
	}
	
	static Button buildGenerateButton(int x, int y, int xSize, int ySize) {
		
		Button button = new Button("Generate");
		
		button.setBounds(x, y, xSize, ySize);  
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				GUI.setSheet(hardCodedSheet);
				System.out.println("WIP");
				
			}
		});
		
		return button;
	}
	
	static void solveSudoku(Sheet sheet) {
		
		SudokuOldSolver sudokuOldSolver = new SudokuOldSolver(sheet.elements);
		
		sudokuOldSolver.solve();
		
		GUI.setSheet(sheet.elements);
		
	}
}	