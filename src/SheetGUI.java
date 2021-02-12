
import java.awt.*;

public class SheetGUI extends Frame{
	
	final int size;
	
	ElementGUI[] elements;
	
	SheetGUI(int size) {
		
		this.size = size;
		
		ArrayLooper2D a = new ArrayLooper2D(this.size);
		
		elements = new ElementGUI[a.getMax()];
		
		for (int i = 1; i <= elements.length; i++) {
			
			elements[i - 1] = new ElementGUI(a.getX(i) * 50, a.getY(i) * 50);
			
			add(elements[i - 1]);
		}
			
		this.setSize(200, 200);
				
		this.setLayout(null);
				
		this.setVisible(true);
		
	}
	
	public int[] getSheet() { // TODO : Next step
		return null;
	}
	
}
