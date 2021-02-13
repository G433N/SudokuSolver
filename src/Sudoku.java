import java.awt.*;
import java.awt.event.*;

	/*
	 * TODO
	 * Generate button - DONE
	 * Variable for GUI distance 
	 * Exit function - DONE
	 * Research Sudoku theory 
	 * And more
	 */

public class Sudoku {
	
	static SheetGUI GUI;
	
	final static int gridSize = 9;
	final static int gridXMargin = 20;
	final static int gridYMargin = 20;
	
	final static int emlementSize = 30;
	final static int elementDistance = 30;
	
	
	public static void main(String[] args) {
		
		GUI = new SheetGUI(gridSize, gridXMargin, 2 * gridYMargin, emlementSize, elementDistance, gridXMargin * 2 + gridSize * elementDistance, gridYMargin * 2 + (gridSize + 3) * elementDistance);
		
		GUI.add(buildSolveButton(gridXMargin, 3 * gridYMargin + gridSize * elementDistance, 2 * elementDistance, emlementSize));
		
		GUI.add(buildResetButton(gridXMargin + 2 * elementDistance, 3 * gridYMargin + gridSize * elementDistance, 2 * elementDistance, emlementSize));
		
		GUI.add(buildGenerateButton(gridXMargin + 4 * elementDistance, 3 * gridYMargin + gridSize * elementDistance, 2 * elementDistance, emlementSize));
	}
	
	static void solveSudoku(Sheet sheet) {
		sheet.println();
	}
	
	static Button buildSolveButton(int x, int y, int xSize, int ySize) {
		
		Button button = new Button("Solve");
		
		button.setBounds(x, y, xSize, ySize);  
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Sheet sheet = new Sheet(GUI.getSheet());
				solveSudoku(sheet);
				
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
				
				GUI.resetSheet();
				
			}
		});
		
		return button;
	}
}	