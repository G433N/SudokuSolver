package com.green.sudoku.gui;
import java.awt.*;
import java.awt.event.*;

import com.green.sudoku.Cell;

@SuppressWarnings("serial")
public class CellGUI extends Button{

	public int value;
	private int x;
	private int y;
	
	public CellGUI(int xPos, int yPos, int size, int x, int y) {
		
		this.value = 0;
		this.x = x;
		this.y = y;
		
		this.setLabel(value);
		
		this.setBounds(xPos, yPos, size, size);
		
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
					value++;
					
					if (value == 10) value = 0;
					
					setLabel(value);
				}
			}
		);
	}

	public void setLabel(int num) {
		
		this.setLabel(Integer.toString(num));
		
	}
	
	public Cell getCell() {
		return new Cell(this.value, this.x, this.y);
	}
}
