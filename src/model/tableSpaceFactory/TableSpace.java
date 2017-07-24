package model.tableSpaceFactory;

import java.util.List;

import model.Dbf;

public abstract class TableSpace {
	
	private String name;
	private Long size;
	private String status;
	private double fillingRate;
	public TableSpace(String name, Long size, String status) {
		super();
		this.name = name;
		this.size = size;
		this.status = status;
	}
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
	public TableSpace(String name, Long size, String status, double fillingRate) {
		super();
		this.name = name;
		this.size = size;
		this.status = status;
		this.fillingRate = fillingRate;
	}
	@Override
	public String toString() {
		return "TableSpace [name=" + name + ", size=" + size + ", status="
				+ status + ", fillingRate=" + fillingRate + ", dbfList="
				+ dbfList + "]";
	}
	
	
	
}
