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
	
	static SheetGUI sheetGUI;
	
	public static void main(String[] args) {
		
		sheetGUI = new SheetGUI(9, 40, 40);
		
		sheetGUI.add(buildSolveButton());
		
		sheetGUI.add(buildResetButton());
		
		sheetGUI.add(buildGenerateButton());
	}
	
	static void solveSudoku(Sheet sheet) {
		sheet.println();
	}
	
	static Button buildSolveButton() {
		
		Button solveButton = new Button("Solve");
		
		solveButton.setBounds(40, 10 * 50, 80, 30);  
		
		solveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Sheet sheet = new Sheet(sheetGUI.getSheet());
				solveSudoku(sheet);
				
			}
		});
		
		return solveButton;
	}
	
	static Button buildResetButton() {
		
		Button resetButton = new Button("Reset");
		
		resetButton.setBounds(40 + 80 + 15, 10 * 50, 80, 30);  
		
		resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				sheetGUI.resetSheet();
				
			}
		});
		
		return resetButton;
	}
	
	static Button buildGenerateButton() {
		
		Button resetButton = new Button("Generate");
		
		resetButton.setBounds(40 + 80*2 + 15 * 2, 10 * 50, 80, 30);  
		
		resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				sheetGUI.resetSheet();
				
			}
		});
		
		return resetButton;
	}
}	