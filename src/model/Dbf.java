package model;

import model.tableSpaceFactory.TableSpace;

public class Dbf {

	private String name;
	private String path;
	private Long size;
	private TableSpace tableSpace;
	
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
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	public TableSpace getTableSpace() {
		return tableSpace;
	}
	public void setTableSpace(TableSpace tableSpace) {
		this.tableSpace = tableSpace;
	}
	public Dbf() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dbf(String name, String path, Long size, TableSpace tableSpace) {
		super();
		this.name = name;
		this.path = path;
		this.size = size;
		this.tableSpace = tableSpace;
	}
	
	
}
