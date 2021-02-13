import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class ElementGUI extends Button{

	int num;
	
	ElementGUI(int x, int y, int size) {
		
		this.num = 0;
		
		this.setLabel(num);
		
		this.setBounds(x, y, size, size);
		
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
					num++;
					
					if (num == 10) num = 0;
					
					setLabel(num);
				}
			}
		);
	}

	void setLabel(int num2) {
		
		this.setLabel(Integer.toString(num2));
		
	}	
}
