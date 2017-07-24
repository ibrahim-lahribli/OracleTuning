package model;

public class LogBuffer {
	
	private int value;
	
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	public LogBuffer( int value) {
		super();
		
		this.value = value;
	}
	public LogBuffer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LogBuffer [value=" + value + "]";
	}
	

}
