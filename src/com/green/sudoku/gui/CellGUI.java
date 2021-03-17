package com.green.sudoku.gui;
import java.awt.*;
import java.awt.event.*;

import com.green.sudoku.Cell;

@SuppressWarnings("serial")
public class CellGUI extends Button{

	public int num;
	private int x;
	private int y;
	
	public CellGUI(int xPos, int yPos, int size, int x, int y) {
		
		this.num = 0;
		this.x = x;
		this.y = y;
		
		this.setLabel(num);
		
		this.setBounds(xPos, yPos, size, size);
		
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
	
	public Cell getCell() {
		return new Cell(this.num, this.x, this.y);
	}
}
