import java.awt.*;
import java.awt.event.*;

public class ElementGUI extends Button{

	int num;
	
	ElementGUI(int x, int y) {
		
		this.num = 0;
		
		this.setLabel(num);
		
		this.setBounds(x, y, 30, 30);
		
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
