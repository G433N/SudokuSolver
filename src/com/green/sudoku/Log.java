package com.green.sudoku;

public class Log {
	
	final int x;
	final int y;
	final int oldValue;
	final int newValue;
	final String note;
	
	// TODO Add possibilities?
	// TODO Add note types
	
	public Log(int x, int y, int oldValue, int newValue, String note) {
		this.x = x;
		this.y = y;
		this.oldValue = oldValue;
		this.newValue = newValue;
		this.note = note;
	}
	
	public String getString() {
		return "X : " + this.x + " | Y : " + this.y + " | Value : " + this.oldValue + " --> " + this.newValue + " | Note : " + this.note;
	}
	
	public void println() {
		System.out.println(this.getString());
	}
}