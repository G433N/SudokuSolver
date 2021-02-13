package com.green.sudoku.gui.buttons;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class ModeButton extends Button{
	
	String[] modes;
	int currentMode = 0;
	
	public ModeButton(int x, int y, int xSize, int ySize, String[] modes) {
		
		this.modes = modes;
		
		setLabel(modes[currentMode]);	
		
		setBounds(x, y, xSize, ySize);  
		
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				currentMode++;
				
				if (currentMode == modes.length) currentMode = 0;
				
				setLabel(modes[currentMode]);	
			}
		});
		
	}
	
	public String getMode() {
		return modes[currentMode];
	}

}
