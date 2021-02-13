
public class Sheet { // Probably temporary
	
	final int size;
	
	int[][] elements;
	
	Sheet(int size) {
		
		this.size = size;
		
		this.elements = new int[size][size];
		
		ArrayLooper2D a = new ArrayLooper2D(this.size);
		
		for (int i = 1; i <= a.getMax(); i++) {
			
			this.elements[a.getY(i)][a.getX(i)] = 0;
			
		}
	}
	
	Sheet(Sheet sheet) {
		
		this.size = sheet.size;
		
		this.elements = sheet.elements;
	}
	
	Sheet(int[][] elements) {
		
		this.size = elements.length;
		
		this.elements = elements;
	}
	
	
	void println() {
		
		ArrayLooper2D a = new ArrayLooper2D(this.size);
		
		for (int i = 1; i <= a.getMax(); i++) {
			
			if(a.getX(i) == 0) System.out.println();
			
			System.out.print(this.elements[a.getY(i)][a.getX(i)]);
		}	
	}
}
