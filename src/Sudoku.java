
import java.awt.*;

public class Sudoku {
	
	public Frame createFrame() {
		
		Frame f = new Frame();
		
		ElementGUI b = new ElementGUI(1, 1);
		
		f.add(b);
		
		f.setSize(300, 300);
		
		f.setLayout(null);
		
		f.setVisible(true);
		
		return f;
	}
	
	
	
	public static void main(String[] args) {
		
		SheetGUI sheetGUI = new SheetGUI(3);
		
	}
}	
