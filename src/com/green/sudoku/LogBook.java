package com.green.sudoku;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LogBook {
	
	public ArrayList<Log> logs;
	private String fileName;
	
	public LogBook() {
		this.logs = new ArrayList<>();
		this.fileName = "log.txt";
		
		this.resetLogFile();
		
	}
	
	public void addLog(int x, int y, int oldValue, int newValue, String note) {
		Log log = new Log(x, y, oldValue, newValue, note);
		this.logs.add(log);
	}
	
	public void addLog(int x, int y, int oldValue, int newValue) {
		addLog(x,  y,  oldValue,  newValue, "");
	}
	
	public void printAll() {
		for (Log log : this.logs) log.println(); 
	}
	
	public void writeAllToFile() {
		
		try {
			FileWriter logFile = new FileWriter(this.fileName);
			
			for (Log log : this.logs) {
				logFile.append(log.getString() + "\n");
			}
			
			logFile.close();
		}
		catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
		
	}
	
	private void resetLogFile() {
		
		File fileLog = new File(this.fileName);
		
		fileLog.delete();
		try {
			fileLog.createNewFile();
		}
		catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
		
		
	}
}
