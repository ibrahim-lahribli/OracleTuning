package model;

public class Log_Buffer {
	private String name;
	private int value;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	public Log_Buffer(String name, int value) {
		super();
		this.name = name;
		this.value = value;
	}
	

}
