package service;

import model.LogBuffer;

public interface LogBfManager {
	public int getLogbufferState();
	public LogBuffer getLogBuffer();
	public void increaseSize(double percent);
	public void decreaseSize(double percent);
	public void setSize(int size);

}
