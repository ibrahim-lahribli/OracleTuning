package model;

public class RedoFile {
	private String name;
	private String path;
	private int size;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public RedoFile(String path, int size) {
		super();
		this.path = path;
		this.size = size;
	}
	
	

}
