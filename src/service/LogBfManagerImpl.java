package service;


import java.sql.SQLException;

import javax.swing.JOptionPane;

import dao.DbConfig;
import dao.LogBfDao;
import model.LogBuffer;

public class LogBfManagerImpl  {

	
LogBfDao lbd=new LogBfDao();
	
	public LogBuffer getLogBuffer() {
		// TODO Auto-generated method stub
		LogBuffer lg=null;
		 
		lbd.getLogBuffer();
	      
		 return lg;
	            
	        
	}

	
	public void increaseSize(double percent) {
		// TODO Auto-generated method stub
		lbd.increaseSize(percent);
		
}


	public void decreaseSize(double percent) {
		// TODO Auto-generated method stub
		lbd.decreaseSize(percent);
	}

	
	public void setSize(int size) {
		// TODO Auto-generated method stub
		lbd.setSize(size);
		
	}

	public int getLogbufferState() {
		
		
		return lbd.getLogbufferState();
	      

	}}
