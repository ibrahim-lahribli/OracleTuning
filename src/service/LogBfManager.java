package service;

import model.LogBuffer;

public interface LogBfManager {
	
	public LogBuffer getLogBuffer();
	public void increaseSize(int percent);
	public void decreaseSize(int percent);
	public void setSize(int size);

}
