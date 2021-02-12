
import java.awt.*;

public class SheetGUI extends Frame{
	
	final int size;
	
	ElementGUI[] elements;
	
	SheetGUI(int size) {
		
		this.size = size;
		
		ArrayLooper2D a = new ArrayLooper2D(this.size);
		
		elements = new ElementGUI[a.getMax()];
		
		System.out.println(elements.length);
		
		for (int i = 1; i <= elements.length; i++) {
			
			elements[i - 1] = new ElementGUI(a.getX(i) * 50, a.getY(i) * 50);
			
			System.out.println("X: " + a.getX(i) + " Y: " + a.getY(i));
			
			add(elements[i - 1]);
		}
			
		
		setSize(500, 500);
				
		setLayout(null);
				
		setVisible(true);
		
	}
	
	public int[] getSheet() {
		return null;
	}
	
}
