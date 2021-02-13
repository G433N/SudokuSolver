package com.green.sudoku.gui;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class ElementGUI extends Button{

	public int num;
	
	public ElementGUI(int x, int y, int size) {
		
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

	public void setLabel(int num) {
		
		this.setLabel(Integer.toString(num));
		
	}	
}
