
import java.awt.*;

public class SheetGUI extends Frame{
	
	final int size;
	
	ElementGUI[] elements;
	
	SheetGUI(int size, int x, int y) {
		
		this.size = size;
		
		ArrayLooper2D a = new ArrayLooper2D(this.size);
		
		elements = new ElementGUI[a.getMax()];
		
		for (int i = 1; i <= a.getMax(); i++) {
			
			elements[i - 1] = new ElementGUI(x + a.getX(i) * 50, y + a.getY(i) * 50);
			
			add(elements[i - 1]);
		}
			
		this.setSize(500, 600);
				
		this.setLayout(null);
				
		this.setVisible(true);
		
		this.setTitle("Sudoku");
		
	}
	
	void resetSheet() {
		for (int i = 0; i < elements.length; i++) {
			
			elements[i].num = 0;
			elements[i].setLabel(0);
			
		}
	}
	
	Sheet getSheet() { 
		
		int[][] result = new int[this.size][size];
		
		ArrayLooper2D a = new ArrayLooper2D(this.size);
		
		for (int i = 1; i <= a.getMax(); i++) {
			
			result [a.getY(i)][a.getX(i)] = this.elements[i - 1 ].num;
			
		}
		
		return new Sheet(result);
	}
	
}
