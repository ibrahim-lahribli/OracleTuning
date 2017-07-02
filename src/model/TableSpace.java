package model;

import java.util.List;

import utils.TableSpaceType;

public class TableSpace {
	
	private String name;
	private Long size;
	private String status;
	private TableSpaceType type;
	private double fillingRate;
	private List<Dbf> dbfList;
	
	public List<Dbf> getDbfList() {
		return dbfList;
	}
	public void setDbfList(List<Dbf> dbfList) {
		this.dbfList = dbfList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public TableSpaceType getType() {
		return type;
	}
	public void setType(TableSpaceType type) {
		this.type = type;
	}
	public double getFillingRate() {
		return fillingRate;
	}
	public void setFillingRate(double fillingRate) {
		this.fillingRate = fillingRate;
	}
	public TableSpace() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TableSpace(String name, Long size, String status, TableSpaceType type, double fillingRate) {
		super();
		this.name = name;
		this.size = size;
		this.status = status;
		this.type = type;
		this.fillingRate = fillingRate;
	}
	
	
}
